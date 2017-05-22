package com.jikexuyuan.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.jikexuyuan.kotlin.util.KotlinUtil.suum

/**
 * Basic Syntax
 */
class Main2Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        mTextView!!.setTextColor(Color.RED)
    }

    private var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mTextView = findViewById(R.id.text) as TextView
        mTextView!!.text = getString(R.string.firstKotlin)
        mTextView!!.setOnClickListener(this)

        /**
         * Defining functions
         */
        Log.e("main suum1", "" + suum(3, 5))
        Log.e("main suum2", "sum of 19 and 23 is ${suum(19, 23)}")
        Log.e("main sum", "" + sum(19, 30))
        printSum(50, -1)

        /**
         *Defining local variables
         * Assign-once (read-only)
         * Mutable variable
         */
        val a: Int = 1
        val b = 2
        val c: Int
        c = 3
        Log.e("main variables", "a = $a, b = $b, c = $c")

        /**
         * Mutable variable
         */
        var x = 5;
        x += 1
        Log.e("main Mutable variable", "x is " + x)

        /**
         * Comments
         */
        // This is an end-of-line comment

        /* This is a block comment
                on multiple lines. */

        /**
         *Using string templates
         */
        var d = 1
        val s1 = "d is $d"
        d = 2
        val s2 = "${s1.replace("is", "was")},but now is $d"
        val s3 = "${'$'}9.99"
        Log.e("main string templates", s2 + "\t" + s3)

        Log.e("main string ", "main string max is " + maxOf(10, 50))
        Log.e("main string ", "main string max is " + maxOfAandB(10, 50))

        /**
         * Using nullable values and checking for null
         * toIntOrNull is not resolved
         */
        //        printProduct("a","10")

        /**
         * 使用值检查并自动转换
         */
        printLength("")
        printLength("hello Kotlin")
        printLength(listOf(Any()))
        /**
         * 使用循环
         */
        val itemsByList = listOf("a", "b", "c")
        for (item in itemsByList) {
            Log.e("main loop for", item)
        }
        var index = 0
        while (index < itemsByList.size) {
            Log.e("main loop while ", "item at $index is ${itemsByList[index]}")
            index++
        }
        /**
         * ranges in
         */
        val g = 10
        val h = 9
        if (g in 1..h + 1) {
            Log.e("main ranges in ", "fits in range")
        }
        val list = listOf("a", "b", "c")

        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range too")
        }
        for (m in 1..5) {
            Log.e("main for ",""+m)
        }
        for (n in 1..10 step 2) {
            Log.e("main step", "$n" )
        }
        for (o in 9 downTo 1 step 3) {
            Log.e("main step downto", "$o" )

        }
        /**
         * when
         */
        describe(1)
        /**
         * 使用集合
         */
        val items= listOf("apple","tomato","banana")
        for (item in items) {
            Log.e("main collections",item)
        }
        when{
            "apple" in items ->Log.e("main collections","apple")
            "tomato" in items ->Log.e("main collections","tomato")
            "banana" in items ->Log.e("main collections","banana")
            else -> Log.e("main collections","none")
        }

        /**
         * 使用lambda表达式过滤和映射集合：
         */
        val fruits = listOf("banana", "avocado", "Apple", "kiwi")
        fruits.filter { it.startsWith("a",true) }.sortedBy { it }.forEach { Log.e("main collections lambda",it) }

    }






    fun sum(a: Int, b: Int) = a + b
    fun printSum(a: Int, b: Int) {
        Log.e("main print", "sum of $a and $b is ${a + b}")
    }

    /**
     * Using conditional expressions
     */
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun maxOfAandB(a: Int, b: Int) = if (a > b) a else b

    fun parseInt(str: String): Int? {
        return str.toInt()
    }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // Using `x * y` yields error because they may hold nulls.
        if (x != null && y != null) {
            // x and y are automatically cast to non-nullable after null check
            println(x * y)
        } else {
            println("either '$arg1' or '$arg2' is not a number")
        }
    }

    fun getStringLength(arg1: Any): Int? {
        if (arg1 is String) {
            return arg1.length
        }
        return null
    }

    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }

    fun describe(obj: Any): String = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }
}
