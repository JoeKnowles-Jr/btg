package com.jk.btg.data.model.products

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class PriceTextView(context: Context, attrs: AttributeSet)
    : AppCompatTextView(context, attrs) {




    private var prices = arrayOf<String>("$")
    private var priceToDisplay = 0

    fun setPrices(prices: Array<String>) {
        this.prices = prices
        displayPrice(0)
    }

    fun changePriceIndex(newIndex: Int) {
        priceToDisplay = newIndex
        if (priceToDisplay > 4)
            priceToDisplay = 4
        if (priceToDisplay < 0)
            priceToDisplay = 0
        displayPrice(priceToDisplay)
    }

    fun priceDown() {
        changeDisplayedPrice(true)
    }

    fun priceUp() {
        changeDisplayedPrice(false)
    }

    private fun changeDisplayedPrice(goingDown: Boolean) {
        if (goingDown) {
            --priceToDisplay
            if (priceToDisplay < 0)
                priceToDisplay = 0
        } else {
            ++priceToDisplay
            if (priceToDisplay > 4)
                priceToDisplay = 4
        }
        displayPrice(priceToDisplay)
    }

    private fun displayPrice(which: Int) {
        text = prices[which]
    }

}