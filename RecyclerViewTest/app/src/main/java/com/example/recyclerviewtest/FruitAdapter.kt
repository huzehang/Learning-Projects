package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

/**
 * 适配器类
 * 1.继承RecyclerView.Adapter，并将泛型指定为自己定义的一个内部类，此内部类必需继承RecyclerView.Holder
 * 2.定义内部类，此内部类用于找到fruit_item子项布局中的控件
 * 3.实现RecyclerView.Adapter中的3个抽象方法
 * 4.onCreateViewHolder方法用于在加载时自动创建ViewHolder，此处创建布局fruit_item，并返回加载完成的ViewHolder即可
 * 5.onBindViewHolder方法用于加载完成后把Fruit类的数据和fruit_item中的控件关联起来
 * 6.getItemCount方法返回当前有多少个子项
 */
class FruitAdapter(val fruitList:List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val fruitImage:ImageView = view.findViewById(R.id.imageView)
        val fruitName:TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, fruit.name, Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "${fruit.name}图片", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }

    override fun getItemCount() = fruitList.size
}