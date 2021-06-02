package com.example.guardgps10

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guardgps10.model.ListElement
import com.example.guardgps10.util.HistoryAdapter
import com.example.guardgps10.util.ListAdapter


class historyActivity : AppCompatActivity() {

//    private lateinit var colors: IntArray
//    private var name: Array<String>? = null

    lateinit var elements: MutableList<ListElement>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
//        colors  = resources.getIntArray(R.array.inicial_color)
//        name    = resources.getStringArray(R.array.name_array)

//        init()
    }

    fun init(){
        elements = ArrayList()
        val element = ListElement("#2196f3","1111111.-21333333","23-02-2020","Activo")
        val listElement = listOf(element)

//        val element = ListElement("#9c27b0","1111111.-21333333","23-02-2020","Activo"))
//        val element = ListElement("#1b5e20","1111111.-21333333","23-02-2020","Activo"))
//        val element = ListElement("#ff5722","1111111.-21333333","23-02-2020","Activo"))
//        val element = ListElement("#f44336","1111111.-21333333","23-02-2020","Activo"))


        val listAdapter : HistoryAdapter = HistoryAdapter(this,listElement)
        val lista: ListView = findViewById(R.id.lista)
        lista.adapter = listAdapter
//        val reciclerView: RecyclerView = findViewById(R.id.listReciclerView)
//        reciclerView.setHasFixedSize(true)
//        reciclerView.layoutManager = LinearLayoutManager(this)
//        reciclerView.adapter =
    }
}