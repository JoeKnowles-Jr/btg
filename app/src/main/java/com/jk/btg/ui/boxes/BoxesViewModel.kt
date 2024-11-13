package com.jk.btg.ui.boxes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jk.btg.data.Network
import com.jk.btg.data.model.products.Box
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header

class BoxesViewModel : ViewModel() {
    val boxList = MutableLiveData<ArrayList<Box>>()
    val net = Network()

    private val _text = MutableLiveData<String>().apply {
        value = "This is boxes Fragment"
    }
    val text: LiveData<String> = _text

    val getProductsHandler = object: TextHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseString: String?
        ) {
            TODO("Not yet implemented")
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseString: String?,
            throwable: Throwable?
        ) {
            TODO("Not yet implemented")
        }
    }
}