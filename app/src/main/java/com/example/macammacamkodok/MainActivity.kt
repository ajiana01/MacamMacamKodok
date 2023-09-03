package com.example.macammacamkodok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.macammacamkodok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvKodokers: RecyclerView
    private val list = ArrayList<Kodok>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKodokers = findViewById(R.id.rv_kumpulan_kodok)
        rvKodokers.setHasFixedSize(true)

        list.addAll(getKumpulanKodok())
        showRecyclerList()
    }

    private fun getKumpulanKodok(): ArrayList<Kodok> {
        val dataKodok = resources.getStringArray(R.array.data_kodok)
        val dataPenjelasan = resources.getStringArray(R.array.data_penjelasan)
        val dataFoto = resources.obtainTypedArray(R.array.data_foto)
        val dataAnime = resources.getStringArray(R.array.data_judul_anime)
        val listKodok = ArrayList<Kodok>()
        for (i in dataKodok.indices) {
            val kodok = Kodok(dataKodok[i],dataAnime[i], dataPenjelasan[i], dataFoto.getResourceId(i, -1))
            listKodok.add(kodok)
        }
        return listKodok
    }

    private fun showRecyclerList() {
        rvKodokers.layoutManager = LinearLayoutManager(this)
        val listKodok = ListKodokAdapter(list)
        rvKodokers.adapter = listKodok

        listKodok.setOnItemClickCallback(object : ListKodokAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kodok) {
                val intent = Intent(this@MainActivity, DetailKodok::class.java)
                intent.putExtra(DetailKodok.EXTRA_NAMA, data.nama)
                intent.putExtra(DetailKodok.EXTRA_DETAIL, data.penjelasan)
                intent.putExtra(DetailKodok.EXTRA_ANIME, data.anime)
                intent.putExtra(DetailKodok.EXTRA_FOTO, data.foto)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, About::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}