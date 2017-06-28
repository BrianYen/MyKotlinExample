package com.example.bryanyen.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.locks.Lock

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message.text = "Kotlin Test"
        button.setOnClickListener { message.text = "click" }

//        val okHttpController = OkHttpController()
//        okHttpController.getPublicUtilityListFromServer(object : OkHttpResponseListener.GetPublicUtilityListCallBack {
//            override fun onSuccess(requestData: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onError(errorCode: Int, errorMessage: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        })

        for (i in 1..4) println(i)

        var a: Int = 2
        var b: Int = 4


        if (a == b)
            println("true")
        else
            println("false")

        val list = ArrayList<String>()
        list.add("test")
        val size = list.size
        val item = list[0]

        println("item size: $size")

    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun textV(array: ArrayList<String>) {
        println(array.size)
    }

    fun <T> lock(lock: Lock, body: () -> T): T {
        lock.lock()
        try {
            return body()
        } finally {
            lock.unlock()
        }
    }
}
