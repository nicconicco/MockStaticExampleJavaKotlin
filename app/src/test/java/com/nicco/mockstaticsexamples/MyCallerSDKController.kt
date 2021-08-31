package com.nicco.mockstaticsexamples

class MyCallerSDKController {
    fun callThirtyPartySDK(): String {
        return SDKThirtyParty.getInstance()
    }
}