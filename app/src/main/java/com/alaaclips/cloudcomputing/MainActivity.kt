package com.alaaclips.cloudcomputing

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var username: TextView
    lateinit var phone_numper: TextView
    lateinit var adress: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Firebase.firestore

        username = findViewById(R.id.username)
        phone_numper = findViewById(R.id.phone_numper)
        adress = findViewById(R.id.adress)


        var addContact = findViewById<FloatingActionButton>(R.id.flotAction)


        addContact.setOnClickListener {

            var newContact = Contact("${username.text}", "${phone_numper.text}", "${adress.text}")

            db.collection("contact").add(newContact).addOnSuccessListener { it ->
                Log.e("ALAA", "Conpleeterd")
            }
        }


    }


}