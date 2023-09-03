package com.example.macammacamkodok

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailKodok: AppCompatActivity() {


    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_ANIME = "extra_anime"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_FOTO = "extra_foto"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kodok_detail)

        val namaKodok: TextView = findViewById(R.id.nama_kodok)
        val judulAnime: TextView = findViewById(R.id.tv_anime)
        val penjelasan: TextView = findViewById(R.id.tv_item_penjelasan)
        val foto: ImageView = findViewById(R.id.img_foto)

        val kodok = intent.getStringExtra(EXTRA_NAMA)
        val anime = intent.getStringExtra(EXTRA_ANIME)
        val jelaskan = intent.getStringExtra(EXTRA_DETAIL)
        val fotonya = intent.getIntExtra(EXTRA_FOTO, 0)

        namaKodok.text = kodok
        judulAnime.text = anime
        penjelasan.text = jelaskan
        foto.setImageResource(fotonya)

        val shareButton: Button = findViewById(R.id.action_share)
        shareButton.setOnClickListener {
            val message = "Ini adalah Kodok: ${namaKodok.text} yang akan Anda bagikan."

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }

            startActivity(Intent.createChooser(shareIntent, "Bagikan dengan:"))
        }

    }

}