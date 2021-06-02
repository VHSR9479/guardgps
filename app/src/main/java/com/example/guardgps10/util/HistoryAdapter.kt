package com.example.guardgps10.util

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.guardgps10.R
import com.example.guardgps10.model.ListElement


class HistoryAdapter(private val nContext: Context, private val itemList: List<ListElement>) : ArrayAdapter<ListElement>(nContext,0,itemList){
//    lateinit var iconImage : ImageView
//    lateinit var location : TextView
//    lateinit var date : TextView
//    lateinit var estado: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(nContext).inflate(R.layout.list_history,parent,false)

        val item = itemList[position]

        val iconImage: ImageView = layout.findViewById(R.id.iconImageView)
        val location : TextView  = layout.findViewById(R.id.locationList)
        val date     : TextView  = layout.findViewById(R.id.dateTextViewList)
        val estado   : TextView  = layout.findViewById(R.id.estadoList)

        iconImage.setColorFilter(Color.parseColor(item.color),PorterDuff.Mode.SRC_IN)
        date.setText(item.date)
        location.setText(item.location)
        estado.setText(item.estado)


        return layout
    }


}