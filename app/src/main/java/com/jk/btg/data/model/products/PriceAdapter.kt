package com.jk.btg.data.model.products

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jk.btg.R
import java.text.NumberFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class PriceAdapter : ListAdapter<String, PriceAdapter.PriceViewHolder>() {

    private lateinit var mListener: PriceClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceViewHolder {
        return PriceViewHolder.create(parent, mListener)
    }

    override fun onBindViewHolder(holder: PriceViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class PriceViewHolder(itemView: View, private val listener: PriceClickListener) : RecyclerView.ViewHolder(itemView) {


        @SuppressLint("SetTextI18n")
        fun bind(price: String?) {

        }

        companion object {
            fun create(parent: ViewGroup, listener: PriceClickListener): PriceViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_price_view, parent, false)
                return PriceViewHolder(view, listener)
            }
        }

        class PriceComparator : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return true //oldItem.item == newItem.item && oldItem.value == newItem.value
            }
        }
    }

    fun listenWith(listener: PriceClickListener) {
        mListener = listener
    }

    interface PriceClickListener {
        fun onStringClick(price: String)
        fun onStringLongClick(price: String)
    }
}