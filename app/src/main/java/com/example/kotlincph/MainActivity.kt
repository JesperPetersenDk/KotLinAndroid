package com.example.kotlincph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val buttons = mutableListOf<Button>()

    fun findAllButton(parent:ViewGroup)
    {
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)

            if (child is Button && !child.text.toString().contains("=", false)){
                buttons.add(child)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findAllButton(findViewById<ViewGroup>(R.id.root))

        for (button in buttons)
        {
            button.setOnClickListener {
                textView.setText(textView.text.toString()+button.text.toString())
            }
        }
    }
}
