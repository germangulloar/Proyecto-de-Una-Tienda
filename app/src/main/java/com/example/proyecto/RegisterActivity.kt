package com.example.proyecto

import android.app.admin.SystemUpdatePolicy.ValidationFailedException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private var edName : EditText?=null
    private var edLastName : EditText?=null
    private var edNit : EditText?=null
    private var edEmail : EditText?=null
    private var edTelefono : EditText?=null
    private var edPassword : EditText?=null
    private var chBPolicies : CheckBox?=null
    private val text_Pattern : Pattern = Pattern.compile(
       "[a-zA-Z]*"
    )
    private val password_Ppattern: Pattern= Pattern.compile(
        "^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                "(?=.*[A-Z])"+
                "(?=.*[@#$%^&+=])"+
                "(?=\\S+$)"+
                ".{8,}"+
                "$"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edName= findViewById(R.id.edtname)
        edLastName = findViewById(R.id.edtlastname)
        edNit = findViewById(R.id.edNit)
        edEmail = findViewById(R.id.edtEmail)
        edTelefono = findViewById(R.id.edTelefono)
        edPassword= findViewById(R.id.edtPasswordR)
        chBPolicies = findViewById(R.id.chb_Policies)



    }

    fun OnRegister(view: View) {
        if(ValidateForm())
        {
            Toast.makeText(this,"correcto",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }
    }
    private fun ValidateForm():Boolean {
        var validate = true
        val nameInput = edName!!.text.toString()
        val lastnameInput = edLastName!!.text.toString()
        val nitInput = edNit!!.text.toString()
        val emailInput = edEmail!!.text.toString()
        val telefonoInput = edTelefono.toString()
        val paswordInput = edPassword.toString()
        if (!chBPolicies!!.isChecked) {
            validate = false
        }
        if (TextUtils.isEmpty(edName!!.text.toString()))
        {
            edName!!.error = "required"
            validate = false
        } else if (!text_Pattern.matcher(nameInput.replace(" ", "")).matches())
        {
            edName!!.error = "nombre no valido"
            validate = false
        } else edName!!.error = null


        if (TextUtils.isEmpty(edPassword!!.text.toString()))
        {
            edPassword!!.error = "Requerido"
             validate = false
        }else if(!password_Ppattern.matcher(paswordInput).matches())
        {
            edPassword!!.error="no cumple con las politicas"
        } else edPassword!!.error= null

        return validate
    }
}