package com.example.dzcalkulator

import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(),View.OnClickListener {
        private lateinit var toolbarMain: Toolbar
        private lateinit var firstOperandTE: EditText
        private lateinit var secondOperandTE: EditText

        private lateinit var sumButtonBTN: Button
        private lateinit var difButtonBTN: Button

        private lateinit var resultTV: TextView



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            toolbarMain=findViewById(R.id.toolbarMain)
            setSupportActionBar(toolbarMain)
            title="Калькулятор времени"
            toolbarMain.subtitle="версия 1"
            toolbarMain.setLogo(R.drawable.ic_android_black_24dp)

            firstOperandTE = findViewById(R.id.festOperandET)
            secondOperandTE = findViewById(R.id.secondOperandET)

            sumButtonBTN = findViewById(R.id.buttonSumBTN)
            difButtonBTN = findViewById(R.id.buttonDifBTN)


            resultTV = findViewById(R.id.resultTV)

            sumButtonBTN.setOnClickListener(this)
            difButtonBTN.setOnClickListener(this)

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.resetMenuMain -> {
                firstOperandTE.text.clear()
                secondOperandTE.text.clear()
                resultTV.text = "Результат"
                Toast.makeText(applicationContext, "Данные очищены",
                    Toast.LENGTH_LONG).show()
                
            }
            R.id.exitMenuMain ->{

                Toast.makeText(applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG).show()
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
    }


        override fun onClick(v: View) {

            if (firstOperandTE.text.isEmpty() || secondOperandTE.text.isEmpty()) {
                return
            }
            val first = firstOperandTE.text.toString()
            val second = secondOperandTE.text.toString()
            val sum=Operation(first, second).sum()
            val dif=Operation(first, second).dif()

            val result = when (v.id) {
                R.id.buttonSumBTN -> {
                    Toast.makeText(
                        applicationContext,
                        "Результат суммы: $sum",
                        Toast.LENGTH_LONG
                    ).show()
                    resultTV.text="$sum"
                }
                R.id.buttonDifBTN ->{
                    Toast.makeText(
                        applicationContext,
                        "Результат разности: $dif",
                        Toast.LENGTH_LONG
                    ).show()
                    resultTV.text="$dif"

                }


                else -> "0.0"
            }

        }
    }


