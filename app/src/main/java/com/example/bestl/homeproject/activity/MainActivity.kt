package com.example.bestl.homeproject.activity

import android.os.Bundle
import com.example.bestl.homeproject.R
import com.example.bestl.homeproject.interface_listener.OnCreateListener


class MainActivity : BaseActivity(), OnCreateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setView()
        setListener()

    }

    override fun init() {

    }

    override fun setView() {
    }

    override fun setListener() {

    }

}
