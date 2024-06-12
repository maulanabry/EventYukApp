package com.example.eventyukapp.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.navigation.Screen
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") } // State variable for email
    var password by remember { mutableStateOf("") } // State variable for password
    var notificationMessage by remember { mutableStateOf<String?>(null) } // State variable for notification message
    val coroutineScope = rememberCoroutineScope()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Welcome Text
        Text(
            text = "Selamat Datang",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color(0xFF2196F3) // Orange color for welcome text
            ),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        )

        // Description Text
        Text(
            text = "Silahkan login di sini",
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 18.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it }, // Update email state on change
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it }, // Update password state on change
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            visualTransformation = PasswordVisualTransformation() // Hide password characters
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Row to align "Lupa password?" to the right
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            ClickableText(
                text = AnnotatedString("Lupa password?"),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 16.sp,
                    color = Color(0xFF2196F3) // Orange color for "Lupa password?" text
                ),
                onClick = {
                    // Handle forgot password action
                },
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                coroutineScope.launch {
                    val auth = FirebaseAuth.getInstance()
                    try {
                        val result = auth.signInWithEmailAndPassword(email, password)
                        notificationMessage = "Login berhasil."
                        // Save user data to Realtime Database
                        saveUserToRealtimeDatabase(email, password)
//                navController.navigate(Screen.Beranda.route)
                    } catch (e: Exception) {
                        notificationMessage = "Login gagal: ${e.message}"
                    }
                }
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3) // Orange color for button
            ),
            shape = RoundedCornerShape(4.dp) // Rounded corners
        ) {
            Text("Masuk")
        }
    Spacer(modifier = Modifier.height(16.dp))

    // Buat Akun Button
    Button(
        onClick = { /* Handle create new account action */ },
        modifier = Modifier.width(200.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3) // Orange color for button
        ),
        shape = RoundedCornerShape(4.dp) // Rounded corners
        ) {
        Text("Buat Akun Baru")
    }
        // Notification Message
        notificationMessage?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = if (it.startsWith("Login berhasil")) Color.Green else Color.Red
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}


private fun saveUserToRealtimeDatabase(email: String, password: String) {
    val database = Firebase.database
    val myRef = database.getReference("users")

    val user = hashMapOf(
        "email" to email,
        "password" to password
    )

    // Push the user data to the database
    myRef.push().setValue(user)
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}