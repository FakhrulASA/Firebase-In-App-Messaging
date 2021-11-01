package com.fakhrulasa.firebaseinappmessage

import android.util.Log
import com.google.firebase.inappmessaging.model.InAppMessage

import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener
import com.google.firebase.inappmessaging.model.Action


class MyClickListenerBundles : FirebaseInAppMessagingClickListener {
    override fun messageClicked(inAppMessage: InAppMessage, action: Action) {
        // Determine which URL the user clicked
        val url: String? = action.actionUrl

        // Get data bundle for the inapp message
        val dataBundle: Map<*, *>? = inAppMessage.data
        // ...
        Log.d("dataPaisi",dataBundle.toString())
    }
}
