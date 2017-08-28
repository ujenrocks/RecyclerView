package com.example.acer.recyclerpracitce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListAdapter
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var input : RecyclerView? = null
//    var list : ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById<RecyclerView>(R.id.input)

        input?.layoutManager = LinearLayoutManager(this)

//        var num = ArrayList<String>(100)
        var adapter = ListAdapter()
        input?.adapter = adapter
    }

    class ListAdapter : RecyclerView.Adapter<ListAdapter.Holder>() {
        override fun onBindViewHolder(holder: Holder?, position: Int) {
            holder?.name?.text = position.toString()
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
            val inflater = LayoutInflater.from(parent?.context);
            val view = inflater.inflate(R.layout.display, parent,false)
            val holder = Holder(view);
            return holder;
        }

        override fun getItemCount(): Int {
            return 100
        }

        class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            var name : TextView = itemView?.findViewById<TextView>(R.id.display) as TextView
        }
    }

}
