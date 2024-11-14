package com.jk.btg.ui.boxes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jk.btg.data.Network
import com.jk.btg.data.model.products.Box
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import java.lang.reflect.Type


class BoxesViewModel : ViewModel() {
    val boxList = MutableLiveData<ArrayList<Box>>()
    val net = Network()

    private val _text = MutableLiveData<String>().apply {
        value = "This is boxes Fragment"
    }
    val text: LiveData<String> = _text

    private val getProductsHandler = object: TextHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseString: String?
        ) {
            val type: Type = object : TypeToken<ArrayList<Box>>() {}.type
            val vv = Gson().fromJson(responseString, type) as ArrayList<Box>
            println("vv - $vv")
            boxList.value = vv
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseString: String?,
            throwable: Throwable?
        ) {
            println("ERROR!")
        }
    }

    init {
        net.getProducts(getProductsHandler)
    }
}