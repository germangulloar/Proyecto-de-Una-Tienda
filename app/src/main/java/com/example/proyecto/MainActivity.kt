package com.example.proyecto

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var edtUsername : EditText?=null
    private var edtPassword: TextInputEditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword=findViewById(R.id.edtpassword)
    }

    fun onLogin(botonlogin: View)

    {
        val messagepassword=getString(R.string.messagpassword)
        val messageusername=getString(R.string.messageusername)
        val username : String=edtUsername!!.text.toString()
        if (username=="germangulloar@correo.co")
        {
            if(edtPassword!!.text.toString()=="12345")
            {   val negativebutton={_:DialogInterface,_:Int->}
                val positiveButton={dialog:DialogInterface,which:Int->
                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)
                }

                val dialog=AlertDialog.Builder(this)
                                      .setTitle("Welcome")
                                      .setMessage("User:"+username)
                                      .setPositiveButton("ok",positiveButton)
                                      .setNegativeButton("Cancelar",negativebutton)
                                      .create()
                                      .show()
            }
            else
            {
                val dialog=AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(messagepassword)
                    .create()
                    .show()
            }
        }
        else
        {
        /*   val dialog=AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(messageusername)
                .create()
                .show()

           */
            Toast.makeText(this,messageusername,Toast.LENGTH_LONG).show()
        }
    }

}