package com.example.dzsnec2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var inputTextET: EditText
    private lateinit var saveDataBTN: Button
    private lateinit var deleteDataBTN: Button
    private lateinit var outputTextTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Домашнее задание Checkbox, Snackbar"
        toolbarMain.subtitle = "Задание 1. версия 1"
        toolbarMain.setLogo(R.drawable.ic_android_black_24dp)

        inputTextET = findViewById(R.id.inputTextET)
        saveDataBTN = findViewById(R.id.saveDataBTN)
        deleteDataBTN = findViewById(R.id.deleteDataBTN)
        outputTextTV = findViewById(R.id.outputTextTV)

        saveDataBTN.setOnClickListener{view ->
            val inputData = inputTextET.text.toString()
            outputTextTV.text = inputData
            Snackbar.make(view, "Данные сохранены", Snackbar.LENGTH_SHORT).show()
        }

        deleteDataBTN.setOnClickListener{view ->

            Snackbar.make(view, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                .setAction("Удалить?") {
                    outputTextTV.text = ""
                    Snackbar.make(view, "Данные удалены", Snackbar.LENGTH_SHORT).show()
                }.show()
        }
    }



}
