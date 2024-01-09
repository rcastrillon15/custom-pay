package com.rodri.custom_pay

class CustomRequest {
    fun makeGet(params: String):String {
        return "CustomApiRequest: GET called with params: $params"
    }

    fun makePost(params: String):String {
        return "CustomApiRequest: POST called with params: $params"
    }
}
