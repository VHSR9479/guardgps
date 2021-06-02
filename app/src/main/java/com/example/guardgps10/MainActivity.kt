package com.example.guardgps10

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.guardgps10.fragment.fragment_signUp
import com.example.guardgps10.fragment.loginFragment
import com.example.guardgps10.util.util

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var linearLayour: LinearLayout? = null
    lateinit var login: Button
    lateinit var signup: Button
    lateinit var gmail: ImageButton
    private var util:util = util()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        util.validarConexioninternet(this)
        Toast.makeText(this, "Iniciando App...", Toast.LENGTH_LONG).show()
        this.linearLayour = findViewById(R.id.linearForm)
        login = findViewById(R.id.login)
        login.setOnClickListener(this)
        signup = findViewById(R.id.signUp)
        signup.setOnClickListener(this)
        gmail = findViewById(R.id.btngmail)
        gmail.setOnClickListener(this)



        val  navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onClick(view: View)  {
       Toast.makeText(this, "Cambiando de Fondo", Toast.LENGTH_LONG).show()

        var fragment: Fragment = loginFragment()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.popBackStack()

        when (view?.id) {
                R.id.login ->{
                    fragment = loginFragment()
                    navController.navigate(R.id.login)
                    this.linearLayour?.setBackground(getResources().getDrawable(R.drawable.peque1))
                    this.signup.setBackground(getResources().getDrawable(R.drawable.boton_invisible))
                    this.login.setBackground(getResources().getDrawable(R.drawable.boton_ovalado))
                }

                R.id.signUp ->{
                    fragment = fragment_signUp()
                    navController.navigate(R.id.signUp)
                    this.linearLayour?.setBackground(getResources().getDrawable(R.drawable.peque2))
                    this.signup.setBackground(getResources().getDrawable(R.drawable.boton_ovalado))
                    this.login.setBackground(getResources().getDrawable(R.drawable.boton_invisible))
                }

            }

            if (view?.id == R.id.btngmail){
                val intento = Intent(this,historyActivity::class.java)
                startActivity(intento)
            }


        }

}