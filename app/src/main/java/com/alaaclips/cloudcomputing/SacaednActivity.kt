package com.alaaclips.cloudcomputing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alaaclips.cloudcomputing.Adapter.NewsAdapter
import com.alaaclips.cloudcomputing.Model.Product
import com.google.firebase.analytics.FirebaseAnalytics

class SacaednActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    lateinit var news_rv:RecyclerView
    lateinit var listdata:List<Product>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sacaedn)
        news_rv=findViewById<RecyclerView>(R.id.news_rv)
        val data= mutableListOf<Product>()
        data.add(Product("food","KAPAPE","https://i.pinimg.com/564x/0b/d1/06/0bd10633751dd5383f6afd6df22d2375.jpg"))
        data.add(Product("food","KAPAPE","https://i.pinimg.com/564x/0b/d1/06/0bd10633751dd5383f6afd6df22d2375.jpg"))
        data.add(Product("food","KAPAPE","https://i.pinimg.com/236x/a2/05/20/a205207e6834068af1519979ae750e38.jpg"))
        data.add(Product("food","KAPAPE","https://i.pinimg.com/236x/a2/05/20/a205207e6834068af1519979ae750e38.jpg"))
        data.add(Product("Clodes","TYCHART","https://i.pinimg.com/236x/a2/05/20/a205207e6834068af1519979ae750e38.jpg"))
        data.add(Product("Clodes","TYCHART","https://i.pinimg.com/236x/a2/05/20/a205207e6834068af1519979ae750e38.jpg"))
        data.add(Product("Electronic","LAPTOP","https://i.pinimg.com/236x/a2/05/20/a205207e6834068af1519979ae750e38.jpg"))
        data.add(Product("Electronic","LAPTOP","https://i.pinimg.com/236x/a2/05/20/a205207e6834068af1519979ae750e38.jpg"))




        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        Secrre("SacaednActivity")

        var i = intent
        var tyepdata = i.getStringExtra("tyepdata")

        if (tyepdata == "food") {
            Log.e("ALAA", "food")
            listdata= data.filter { s -> s.typ == "food" }

        } else if (tyepdata == "Clodes") {

            Log.e("ALAA", "Clodes")
            listdata= data.filter { s -> s.typ == "Clodes" }

        } else {
            Log.e("ALAA", "Electronic")
            listdata= data.filter { s -> s.typ == "Electronic" }

        }



        news_rv.layoutManager = LinearLayoutManager(this)
        news_rv.setHasFixedSize(true)

        val studentAdapter = NewsAdapter(this,listdata)
        news_rv.adapter=studentAdapter


    }


    fun Secrre(nameScreen:String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,nameScreen)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "SacaednActivity")
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }
}