package com.example.eventyukapp.data

import com.example.eventyukapp.R
import com.example.eventyukapp.model.EventItem


object DummyData {
    val eventData = listOf(
        EventItem(
            id = 1,
            name = "Konser Taylor Swift",
            location = "Stadion Gelora Bung Karno Jakarta",
            time = System.currentTimeMillis() + 86400000, // 1 hari dari sekarang
            description = "Konser spektakuler oleh Taylor Swift",
            longDescription = "Bergabunglah dengan kami untuk sebuah malam yang penuh kesenangan dengan penampilan langsung oleh penyanyi terkenal Taylor Swift. Nikmati musik, tarian, dan kegembiraan sepanjang malam. Konser ini akan menampilkan sejumlah lagu hitsnya yang membuat Anda bergoyang dan bernyanyi sepanjang malam. Jangan lewatkan pengalaman yang tak terlupakan ini!",
            picture = R.drawable.img_poster_1,
            mapsLink = "https://www.google.com/maps/place/Stadion+Gelora+Bung+Karno"
        ),
        EventItem(
            id = 2,
            name = "Sport Veteran",
            location = "Giriloka UPN Veteran Jawa Timur",
            time = System.currentTimeMillis() + 172800000, // 2 hari dari sekarang
            description = "Lomba Terbesar di Jawa Timur",
            longDescription = "Bergabunglah dengan ribuan peserta untuk kompetisi olahraga terbesar di Jawa Timur. Ada berbagai macam olahraga untuk semua tingkatan, dari pemula hingga profesional. Selain kompetisi, acara ini juga menawarkan hiburan lain seperti pertunjukan musik dan pameran makanan. Jangan lewatkan kesempatan untuk merayakan semangat olahraga bersama komunitas lokal!",
            picture = R.drawable.img_poster_2,
            mapsLink = "https://maps.app.goo.gl/g3Z8i96PfxmS4ULL8"
        ),
        EventItem(
            id = 3,
            name = "Penampilan Pencraft Contest",
            location = "Jl. Pahlawan No. 123, Surabaya",
            time = System.currentTimeMillis() + 259200000, // 3 hari dari sekarang
            description = "Bersiaplah untuk menyaksikan para peserta memamerkan karya mereka di Pencraft Contest.",
            longDescription = "Penampilan Pencraft Contest akan menampilkan karya-karya luar biasa dari para peserta kontes. Jangan lewatkan kesempatan ini untuk melihat karya kreatif yang menakjubkan dari seniman lokal. Ada berbagai macam kategori kontes yang mencakup berbagai jenis karya seni, termasuk seni lukis, fotografi, dan seni digital. Acara ini juga akan diisi dengan pertunjukan musik langsung dan penjualan karya seni oleh para peserta.",
            picture = R.drawable.img_poster_3,
            mapsLink = "https://www.google.com/maps/place/Jl.+Pahlawan+No.+123"
        ),
        EventItem(
            id = 4,
            name = "SEKOIN: Seminar Kewirausahaan Indonesia",
            location = "Gedung Pusat UPN Veteran Jawa Timur",
            time = System.currentTimeMillis() + 432000000, // 5 hari dari sekarang
            description = "Konferensi tahunan mengenai teknologi terbaru",
            longDescription = "SEKOIN adalah seminar tahunan yang menghadirkan para pemimpin industri dan pakar teknologi untuk berbagi wawasan tentang tren terbaru dalam dunia kewirausahaan dan teknologi. Acara ini menawarkan berbagai sesi diskusi, lokakarya, dan presentasi dari para ahli industri yang berpengalaman. Bergabunglah dengan kami untuk mendapatkan wawasan tentang peluang baru dalam bisnis dan teknologi serta untuk menjalin hubungan dengan para profesional dan pengusaha lainnya.",
            picture = R.drawable.img_poster_4,
            mapsLink = "https://www.google.com/maps/place/Gedung+Pusat+UPN+Veteran+Jawa+Timur"
        )
    )
}