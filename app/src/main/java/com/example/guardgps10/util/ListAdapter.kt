package com.example.guardgps10.util

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guardgps10.R
import com.example.guardgps10.model.ListElement

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private lateinit var  mData : List<ListElement>
    private lateinit var  mInflater: LayoutInflater
    private lateinit var context: Context


    constructor (itemList: List<ListElement>,  context: Context){
        this.mData = itemList
        this.mInflater = LayoutInflater.from(context)
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = this.mInflater.inflate(R.layout.list_history, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(mData.get(position))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setItems(items: List<ListElement>){ mData=items }

    public class ViewHolder : RecyclerView.ViewHolder{
        lateinit var iconImage : ImageView
        lateinit var location : TextView
        lateinit var date : TextView
        lateinit var estado: TextView

        constructor(itemView: View):super(itemView){
            iconImage = itemView.findViewById(R.id.iconImageView)
            location = itemView.findViewById(R.id.locationList)
            date = itemView.findViewById(R.id.dateTextViewList)
            estado = itemView.findViewById(R.id.estadoList)
        }
        fun bindData (item: ListElement){
            iconImage.setColorFilter(Color.parseColor(item.color),PorterDuff.Mode.SRC_IN)
            date.setText(item.date)
            location.setText(item.location)
            estado.setText(item.estado)
        }

    }

}
