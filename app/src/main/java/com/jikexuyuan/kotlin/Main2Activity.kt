package com.jikexuyuan.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.jikexuyuan.kotlin.util.KotlinUtil.suum

class Main2Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        mTextView!!.setTextColor(Color.RED)
    }

    private var mTextView: TextView ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mTextView = findViewById(R.id.text) as TextView
        mTextView!!.text = getString(R.string.firstKotlin)
        mTextView!!.setOnClickListener(this)
        Log.e("main",""+suum(3, 5))
    }
}
