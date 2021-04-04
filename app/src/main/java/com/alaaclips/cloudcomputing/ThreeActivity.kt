package com.alaaclips.cloudcomputing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.analytics.FirebaseAnalytics
import com.squareup.picasso.Picasso

class ThreeActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    lateinit var textViewtyp:TextView
    lateinit var textname:TextView
    lateinit var imageViewImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        Secrre("SacaednActivity")

        var i=intent
       var name= i.getStringExtra("name")
       var typy= i.getStringExtra("image")
        var image=i.getStringExtra("typ")
        textViewtyp=findViewById<TextView>(R.id.textViewtyp)
        textname= findViewById<TextView>(R.id.textname)
        imageViewImage= findViewById<ImageView>(R.id.imageViewImage)


        textViewtyp.text=image
        textname.text=name
        Picasso.get().load(typy).into(imageViewImage);


    }


    fun Secrre(nameScreen:String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,nameScreen)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "SacaednActivity")
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }
}
