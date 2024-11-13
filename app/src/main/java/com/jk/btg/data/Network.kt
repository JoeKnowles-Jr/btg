package com.jk.btg.data

import com.jk.btg.data.model.addresses.Address
import com.jk.btg.data.model.customers.Customer
import com.jk.btg.data.model.deliveries.Delivery
import com.jk.btg.data.model.deliveries.DeliveryItem
import com.jk.btg.data.model.products.Box
import com.jk.btg.data.model.users.User
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.RequestParams
import com.loopj.android.http.TextHttpResponseHandler

class Network {
    companion object {
        private const val PRODUCTS_URL = "https://b2g.joeknowles.com/backend/products"
        private const val CUSTOMERS_URL = "https://b2g.joeknowles.com/backend/customers"
        private const val DELIVERIES_URL = "https://b2g.joeknowles.com/backend/deliveries"
        private const val ADDRESSES_URL = "https://b2g.joeknowles.com/backend/addresses"
        private const val ORDERS_URL = "https://b2g.joeknowles.com/backend/orders"
        private const val USERS_URL = "https://b2g.joeknowles.com/backend/users"
    }


    fun getProducts(handler: TextHttpResponseHandler?) {
        AsyncHttpClient().get(PRODUCTS_URL, handler)
    }

    fun getCustomers(handler: TextHttpResponseHandler?) {
        AsyncHttpClient().get(CUSTOMERS_URL, handler)
    }

    fun getDeliveries(handler: TextHttpResponseHandler?) {
        AsyncHttpClient().get(DELIVERIES_URL, handler)
    }

    fun getAddresses(handler: TextHttpResponseHandler?) {
        AsyncHttpClient().get(ADDRESSES_URL, handler)
    }

    fun getOrders(handler: TextHttpResponseHandler?) {
        AsyncHttpClient().get(ORDERS_URL, handler)
    }

    fun getUsers(handler: TextHttpResponseHandler?) {
        AsyncHttpClient().get(USERS_URL, handler)
    }

    fun addProduct(item: Box, handler: TextHttpResponseHandler?) {
        AsyncHttpClient().post(PRODUCTS_URL, createBoxParams(item), handler)
    }

    fun editProduct(item: Box, handler: TextHttpResponseHandler?) {
        AsyncHttpClient().put(PRODUCTS_URL, createBoxParams(item), handler)
    }

    fun deleteProduct(bid: String, handler: TextHttpResponseHandler?) {
        AsyncHttpClient().delete("$PRODUCTS_URL/$bid", handler)
    }

    fun addCustomer(item: Customer, handler: TextHttpResponseHandler?) {
        AsyncHttpClient().post(CUSTOMERS_URL, createCustomerParams(item), handler)
    }

    fun editCustomer(item: Customer, handler: TextHttpResponseHandler?) {
        AsyncHttpClient().put(CUSTOMERS_URL, createCustomerParams(item), handler)
    }

    fun deleteCustomer(cid: String, handler: TextHttpResponseHandler?) {
        AsyncHttpClient().delete("$CUSTOMERS_URL/$cid", handler)
    }

    private fun createBoxParams(item: Box): RequestParams {
        val params: RequestParams = RequestParams("l", item.l)
        params.put("w", item.w)
        params.put("h", item.h)
        params.put("sku", item.sku)
        params.put("bundle", item.bundle)
        params.put("cost", item.cost)
        params.put("priceRetail", item.priceRetail)
        params.put("priceBundle", item.priceBundle)
        params.put("price100", item.price100)
        params.put("price250", item.price250)
        params.put("price500", item.price500)
        params.put("flatL", item.flatL)
        params.put("flatW", item.flatW)
        params.put("flatH", item.flatH)
        params.put("folds", item.folds)
        params.put("foldedL", item.foldedL)
        params.put("foldedW", item.foldedW)
        params.put("foldedH", item.foldedH)
        params.put("weight", item.weight)
        params.put("stockCapacity", item.stockCapacity)
        params.put("stockTrigger", item.stockTrigger)
        params.put("inStock", item.inStock)
        params.put("vendor", item.vendor)
        return params
    }

    private fun createCustomerParams(item: Customer): RequestParams {
        val params: RequestParams = RequestParams("id", item.id)
        params.put("company", item.company)
        params.put("firstName", item.firstName)
        params.put("lastName", item.lastName)
        params.put("email", item.email)
        params.put("phone", item.phone)
        params.put("color", item.color)
        return params
    }

    private fun createDeliveryParams(item: Delivery): RequestParams {
        val params: RequestParams = RequestParams("id", item.id)
        params.put("date", item.date)
        params.put("customer", item.customer)
        params.put("address", item.address)
        params.put("notes", item.notes)
        params.put("status", item.status)
        return params
    }

    private fun createAddressParams(item: Address): RequestParams {
        val params: RequestParams = RequestParams("id", item.id)
        params.put("street1", item.street1)
        params.put("street2", item.street2)
        params.put("city", item.city)
        params.put("state", item.state)
        params.put("zipcode", item.zipcode)
        params.put("customer", item.customer)
        params.put("nickname", item.nickname)
        params.put("archived", item.archived)
        return params
    }

    private fun createUserParams(item: User): RequestParams {
        val params: RequestParams = RequestParams("id", item.id)
        params.put("firstName", item.firstName)
        params.put("lastName", item.lastName)
        params.put("email", item.email)
        params.put("password", item.password)
        params.put("phone", item.phone)
        params.put("needsPwUpdate", item.needsPwUpdate)
        params.put("role", item.role)
        params.put("address", item.address)
        return params
    }

    private fun createDeliveryItemParams(item: DeliveryItem): RequestParams {
        val params: RequestParams = RequestParams("id", item.id)
        params.put("deliveryId", item.deliveryId)
        params.put("sku", item.sku)
        params.put("quantity", item.quantity)
        return params
    }
}




