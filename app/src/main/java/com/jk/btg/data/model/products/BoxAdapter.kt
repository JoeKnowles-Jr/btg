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

class BoxAdapter : ListAdapter<Box, BoxAdapter.BoxViewHolder>(BoxViewHolder.BoxComparator()) {
    companion object {
        private var alternate = false
    }
    private lateinit var mListener: BoxClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxViewHolder {
        return BoxViewHolder.create(parent, mListener)
    }

    override fun onBindViewHolder(holder: BoxViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
        if (position % 2 == 1)
            holder.shadeBackground(true)
        else
            holder.shadeBackground(false)
    }

    class BoxViewHolder(itemView: View, private val listener: BoxClickListener) : RecyclerView.ViewHolder(itemView) {
        private val sku: TextView = itemView.findViewById(R.id.tv_box_view_sku)
        private val dimensL: TextView = itemView.findViewById(R.id.tv_box_view_l)
        private val x1: TextView = itemView.findViewById(R.id.tv_x1)
        private val dimensW: TextView = itemView.findViewById(R.id.tv_box_view_w)
        private val x2: TextView = itemView.findViewById(R.id.tv_x2)
        private val dimensH: TextView = itemView.findViewById(R.id.tv_box_view_h)
        private val bundle: TextView = itemView.findViewById(R.id.tv_box_view_bundle_size)
        private val price: TextView = itemView.findViewById(R.id.tv_box_view_price)
        private val rvPrice: RecyclerView = itemView.findViewById(R.id.rv_prices)


        private var dateFormatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.US)
            .withZone(ZoneId.systemDefault())

        fun shadeBackground(shade: Boolean) {
            if (shade) {
                itemView.setBackgroundColor(Color.parseColor("#88888888"))
                sku.setTextColor(Color.WHITE)
                dimensL.setTextColor(Color.WHITE)
                x1.setTextColor(Color.WHITE)
                dimensW.setTextColor(Color.WHITE)
                x2.setTextColor(Color.WHITE)
                dimensH.setTextColor(Color.WHITE)
                bundle.setTextColor(Color.WHITE)
                price.setTextColor(Color.WHITE)
            } else {
                itemView.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                sku.setTextColor(Color.BLACK)
                dimensL.setTextColor(Color.BLACK)
                x1.setTextColor(Color.BLACK)
                dimensW.setTextColor(Color.BLACK)
                x2.setTextColor(Color.BLACK)
                dimensH.setTextColor(Color.BLACK)
                bundle.setTextColor(Color.BLACK)
                price.setTextColor(Color.BLACK)
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind(box: Box?) {
            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            format.setMaximumFractionDigits(2)
            format.currency = Currency.getInstance("USD")
            val boxClickListener = OnClickListener {
                listener.onBoxClick(box!!)
            }
            val boxLongClickListener = View.OnLongClickListener {
                listener.onBoxLongClick(box!!)
                true
            }
            itemView.setOnClickListener(boxClickListener)
            itemView.setOnLongClickListener(boxLongClickListener)
            sku.text = box?.sku
            val hasDecimalL = box?.l?.mod(1.0) != 0.0
            val hasDecimalW = box?.w?.mod(1.0) != 0.0
            val hasDecimalH = box?.h?.mod(1.0) != 0.0
            if (hasDecimalL)
                dimensL.text = box?.l.toString()
            else
                dimensL.text = box?.l?.toInt().toString()
            if (hasDecimalW)
                dimensW.text = box?.w.toString()
            else
                dimensW.text = box?.w?.toInt().toString()
            if (hasDecimalH)
                dimensH.text = box?.h.toString()
            else
                dimensH.text = box?.h?.toInt().toString()
            bundle.text = box?.bundle.toString()
            val priceRetail = format.format(box?.priceRetail).toString()
            val priceBundle = format.format(box?.priceBundle).toString()
            val price100 = format.format(box?.price100).toString()
            val price250 = format.format(box?.price250).toString()
            val price500 = format.format(box?.price500).toString()
            val priceData = arrayOf(priceRetail, priceBundle, price100, price250, price500)
            val adapter = ArrayAdapter<String>(itemView.context, R.layout.layout_price_view, priceData)
//            rvPrice.adapter = adapter
        }

        companion object {
            fun create(parent: ViewGroup, listener: BoxClickListener): BoxViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_box_view, parent, false)
                return BoxViewHolder(view, listener)
            }
        }

        class BoxComparator : DiffUtil.ItemCallback<Box>() {
            override fun areItemsTheSame(oldItem: Box, newItem: Box): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Box, newItem: Box): Boolean {
                return true //oldItem.item == newItem.item && oldItem.value == newItem.value
            }
        }
    }

    fun listenWith(listener: BoxClickListener) {
        mListener = listener
    }

    interface BoxClickListener {
        fun onBoxClick(box: Box)
        fun onBoxLongClick(box: Box)
    }
}