package com.example.macammacamkodok

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.core.graphics.component3
import androidx.recyclerview.widget.RecyclerView

class ListKodokAdapter(private val listKodok: ArrayList<Kodok>) : RecyclerView.Adapter<ListKodokAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.img_item_foto)
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_kodok)
        val tvPenjelasan: TextView = itemView.findViewById(R.id.tv_item_penjelasan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_baris_kodok, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listKodok.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val urutan = listKodok[position]
        holder.imgFoto.setImageResource(urutan.foto)
        holder.tvNama.text = urutan.nama
        holder.tvPenjelasan.text = urutan.penjelasan

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listKodok[holder.adapterPosition])
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Kodok)
    }


}