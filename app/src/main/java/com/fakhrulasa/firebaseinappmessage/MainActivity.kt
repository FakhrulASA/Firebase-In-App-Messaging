package com.fakhrulasa.firebaseinappmessage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.inappmessaging.FirebaseInAppMessaging


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val instance = FirebaseInAppMessaging.getInstance()
        /**
         * this will be executed when we will dissmiss the Firebase In App messaging pop up
         */
//        instance.addDismissListener {
//            Log.d("dataaaa", it.data.toString())
        /**
         * We will get data in this scope. We will be able to do use data as per our need
         */
//            runOnUiThread {
//                toastMe(it.data.toString())
//            }
//        }

        /**
         * Here custom pair data have been handled and by sending package name as data pair com.fakhrulasa.firebaseinappmessage.SecondTImeActivity 
         * we have start the activity. It is dynamic and any activity can be opened with data provided from back end
         * without sending to a link it wont be executed so use ::// as link. It wont redirect.
         */
        instance.addClickListener { inAppMessage, action ->
            action.actionUrl.toBoolean()
            runOnUiThread {
                startActivity(
                    navigate(
                        this,
                        inAppMessage.data?.get("link").toString()
                    )
                )
            }
        }
    }

    /**
     * A function to navigate to specific activity wth package path. Here pakcage path were com.fakhrulasa.firebaseinappmessage.SecondTImeActivity
     */
    fun navigate(context: Context, str: String): Intent {
        val intent =
            Intent(str).setPackage(
                context.packageName
            )
        return intent
    }

    private fun toastMe(toString: String) {
        Toast.makeText(this, toString, Toast.LENGTH_SHORT).show()
    }


}