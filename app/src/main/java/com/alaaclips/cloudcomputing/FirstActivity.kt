package com.alaaclips.cloudcomputing

import android.R.attr.name
import android.R.id
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics

private var mFirebaseAnalytics: FirebaseAnalytics? = null

class FirstActivity : AppCompatActivity() {
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        Secrre("FirstActivity")

        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)

        button2.setOnClickListener {
            analestic("IDdataAnalsetic","Food")
            var i = Intent(this, SacaednActivity::class.java);
            i.putExtra("tyepdata", "food")
            startActivity(i)
        }

        button3.setOnClickListener {
            analestic("ClodesAnalsetic","Clodes")

            var i = Intent(this, SacaednActivity::class.java);
            i.putExtra("tyepdata", "Clodes")
            startActivity(i)
        }

        button4.setOnClickListener {
            analestic("ElectronicAnalsetic","Electronic")
            var i = Intent(this, SacaednActivity::class.java);
            i.putExtra("tyepdata", "Electronic")
            startActivity(i)
        }

    }

    fun analestic(id:String, name:String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }



    fun Secrre(nameScreen:String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,nameScreen)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "FirstActivity")
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }
}