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
        ),
        EventItem(
            id = 5,
            name = "Harmony Art Showcase",
            location = "Gedung Pusat UPN Veteran Jawa Timur",
            time = System.currentTimeMillis() + 432000000, // 5 hari dari sekarang
            description = "Temukan harmoni seni di acara Harmony Art Showcase, tempat seniman dari berbagai disiplin berkumpul untuk menampilkan karya terbaik mereka.",
            longDescription = "Selamat datang di Harmony Art Showcase, sebuah acara yang didedikasikan untuk merayakan keindahan dan keragaman seni. Di sini, seniman dari berbagai latar belakang akan memamerkan karya-karya mereka, mulai dari lukisan, patung, hingga instalasi seni modern. Acara ini bertujuan untuk menginspirasi dan mempertemukan komunitas seni, menawarkan platform bagi seniman untuk berinteraksi, belajar, dan berkembang bersama. Nikmati pameran, diskusi panel, dan workshop yang akan memperkaya wawasan Anda tentang dunia seni.",
            picture = R.drawable.img_poster_5,
            mapsLink = "https://www.google.com/maps/place/Gedung+Pusat+UPN+Veteran+Jawa+Timur"
        ),
        EventItem(
            id = 6,
            name = "Seminar Nasional Teknologi Industri",
            location = "Gedung Pusat UPN Veteran Jawa Timur",
            time = System.currentTimeMillis() + 432000000, // 5 hari dari sekarang
            description = "Ikuti Seminar Nasional Teknologi Industri untuk mendapatkan wawasan terbaru tentang perkembangan dan inovasi di bidang teknologi industri.",
            longDescription = "Seminar Nasional Teknologi Industri adalah acara tahunan yang mengumpulkan para profesional, akademisi, dan praktisi untuk berbagi pengetahuan dan pengalaman tentang teknologi industri terkini. Dengan menghadirkan pembicara-pembicara terkemuka, seminar ini akan membahas berbagai topik mulai dari otomatisasi, manufaktur cerdas, hingga teknologi ramah lingkungan. Peserta akan mendapatkan kesempatan untuk terlibat dalam diskusi mendalam, jaringan profesional, dan menemukan solusi inovatif untuk tantangan industri. Jangan lewatkan kesempatan untuk memperluas pengetahuan dan koneksi Anda di bidang teknologi industri.",
            picture = R.drawable.img_poster_6,
            mapsLink = "https://www.google.com/maps/place/Gedung+Pusat+UPN+Veteran+Jawa+Timur"
        ),
        EventItem(
            id = 7,
            name = "Konferensi Teknologi",
            location = "Gedung Pusat UPN Veteran Jawa Timur",
            time = System.currentTimeMillis() + 432000000, // 5 hari dari sekarang
            description = "Bergabunglah dalam Konferensi Teknologi, sebuah platform untuk berdiskusi tentang tren dan inovasi terbaru dalam dunia teknologi.",
            longDescription = "Konferensi Teknologi adalah acara premier yang menyatukan para ahli teknologi, pengembang, dan pengusaha untuk mengeksplorasi masa depan teknologi. Acara ini mencakup berbagai sesi yang mendalam, mulai dari kecerdasan buatan, blockchain, hingga teknologi 5G. Dengan menghadirkan para pembicara ahli dan panel diskusi, konferensi ini menawarkan wawasan berharga dan praktek terbaik yang dapat diimplementasikan dalam berbagai industri. Partisipan juga akan memiliki kesempatan untuk networking, berkolaborasi, dan menemukan inspirasi untuk proyek-proyek teknologi masa depan.",
            picture = R.drawable.img_poster_7,
            mapsLink = "https://www.google.com/maps/place/Gedung+Pusat+UPN+Veteran+Jawa+Timur"
        ),
        EventItem(
            id = 8,
            name = "Grafika: Creative Design Competition",
            location = "Gedung Pusat UPN Veteran Jawa Timur",
            time = System.currentTimeMillis() + 432000000, // 5 hari dari sekarang
            description = "Tunjukkan kreativitas Anda di Grafika: Creative Design Competition dan raih penghargaan untuk karya desain terbaik.",
            longDescription = "Grafika: Creative Design Competition adalah ajang kompetisi yang menantang desainer untuk memamerkan bakat dan kreativitas mereka dalam berbagai kategori desain. Acara ini terbuka untuk desainer grafis, ilustrator, dan profesional kreatif lainnya yang ingin menguji kemampuan mereka dan mendapatkan pengakuan di industri. Peserta akan bersaing dalam berbagai tema dan gaya, dinilai oleh panel juri yang terdiri dari para ahli desain terkemuka. Selain kompetisi, acara ini juga menawarkan workshop, seminar, dan kesempatan networking untuk mengembangkan keterampilan dan memperluas jaringan profesional. Jangan lewatkan kesempatan untuk menjadi bagian dari komunitas desain yang dinamis dan berkompetisi di Grafika.",
            picture = R.drawable.img_poster_8,
            mapsLink = "https://www.google.com/maps/place/Gedung+Pusat+UPN+Veteran+Jawa+Timur"
        )
    )
}