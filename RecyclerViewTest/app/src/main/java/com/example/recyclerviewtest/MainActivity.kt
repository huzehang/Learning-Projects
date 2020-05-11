package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 使用RecyclerView
 * 1.在app/build.gradle中添加：implementation 'androidx.recyclerview:recyclerview:1.1.0'
 * 2.在xml布局中添加RecyclerView控件
 * 3.创建数据类和布局文件
 * 4.创建Adapter适配器
 * 5.创建LayoutManager用于指定RecyclerView控件的布局方式
 * 6.关联所有的即可
 */
class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFruits()
        /**
         * LayoutManager有3种内置布局方式
         * 1.LinearLayoutManager垂直或横向布局
         * 2.GridLayoutManager网格布局
         * 3.StaggeredGridLayoutManager瀑布流布局
         */
        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    //本地模拟数据，一般从网络下载数据
    private fun initFruits() {
        repeat(50){
            fruitList.add(Fruit(getString(R.string.fruit_apple), R.drawable.apple_pic))
            fruitList.add(Fruit(getString(R.string.fruit_banana), R.drawable.banana_pic))
            fruitList.add(Fruit(getString(R.string.fruit_orange), R.drawable.orange_pic))
            fruitList.add(Fruit(getString(R.string.fruit_watermelon), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getString(R.string.fruit_pear), R.drawable.pear_pic))
            fruitList.add(Fruit(getString(R.string.fruit_grape), R.drawable.grape_pic))
            fruitList.add(Fruit(getString(R.string.fruit_pineapple), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getString(R.string.fruit_strawberry), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getString(R.string.fruit_cherry), R.drawable.cherry_pic))
            fruitList.add(Fruit(getString(R.string.fruit_mango), R.drawable.mango_pic))
        }
    }
}
