package com.example.helloworld

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("CursoKotlin", "Metodo - onCreate()")

        button3.setOnClickListener { countMe() }

        button2.setOnClickListener{
            // Crear intent (mensaje android)
            val randomIntent = Intent(this, SecondActivity::class.java)
            randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
            startActivity(randomIntent)
        }
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.w("CursoKotlin", "Metodo - onSaveInstanceState()")
        val savedNumber = mensaje.text
        outState?.putCharSequence("savedNumber", savedNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("CursoKotlin", "Metodo - onRestoreInstanceState()")

        val savedNumber = savedInstanceState?.getCharSequence("savedNumber")
        mensaje.text = savedNumber
    }



    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_LONG)
        myToast.show()
    }

    fun countMe () {

        val countString2 = mensaje.text.toString()

        count = Integer.parseInt(countString2)
        count++

        mensaje.text = count.toString()
    }

// ----------------

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(this, "OK clicked", Toast.LENGTH_SHORT).show()
    }

    fun showAlert(view: View) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alerta Android!")
        builder.setMessage("Tenemos un mensaje de advertencia!!")
        builder.setPositiveButton("OK",
            DialogInterface.OnClickListener(function = positiveButtonClick))
        builder.show()
    }

// ----------------

    override fun onStart() {
//        Log.d("CursoKotlin", "Metodo - onStart()")
        super.onStart()
    }

    override fun onResume() {
//        Log.i("CursoKotlin", "Metodo - onResume()")
        super.onResume()
    }



    override fun onPause() {
//        Log.d("CursoKotlin", "Metodo - onPause()")
        super.onPause()
    }

    override fun onStop() {
//        Log.w("CursoKotlin", "Metodo - onStop()")
        super.onStop()
    }

    override fun onDestroy() {
//        Log.e("CursoKotlin", "Metodo - onDestroy()")
        super.onDestroy()
    }
}
