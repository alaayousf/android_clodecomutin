package com.alaaclips.cloudcomputing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class List_All_item : AppCompatActivity() {


    lateinit var db: FirebaseFirestore
    var adpter: FirestoreRecyclerAdapter<Contact, viewholder>? = null
    lateinit var recyclerView: RecyclerView
    lateinit var flotb: FloatingActionButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list__all_item)
        flotb=findViewById(R.id.floatingActionButton)
        recyclerView=findViewById(R.id.recyclerView)


        db = Firebase.firestore


       getallUsers()

        flotb.setOnClickListener {
            val i=Intent(applicationContext, MainActivity::class.java)
            // i.putExtra("object",model.x)
            startActivity(i)
        }


    }







    fun getallUsers() {
        val query = db.collection("contact")
        val option =
            FirestoreRecyclerOptions.Builder<Contact>().setQuery(query, Contact::class.java).build()
        adpter = object : FirestoreRecyclerAdapter<Contact,viewholder>(option){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

                val itemView = LayoutInflater.from(this@List_All_item)
                    .inflate(R.layout.item, parent, false)
                return viewholder(itemView)

            }

            override fun onBindViewHolder(holder: viewholder, position: Int, model: Contact) {

                holder.namexe.text=model.name
                holder.monumper.text=model.numper

                holder.cardView.setOnClickListener {
//                    val i=Intent(applicationContext, MainActivity::class.java)
//                   // i.putExtra("object",model.x)
//                   startActivity(i)
                }

            }

        }

        val  layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager =layoutManager
        recyclerView.adapter = adpter

    }




    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var namexe = itemView.findViewById<TextView>(R.id.name)
        var monumper = itemView.findViewById<TextView>(R.id.monumper)
        var cardView = itemView.findViewById<CardView>(R.id.cardeView)


    }








    override fun onStart() {
        super.onStart()
        adpter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        adpter!!.stopListening()

    }

}