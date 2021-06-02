package com.example.guardgps10.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.guardgps10.fragment.loginFragment


class util {

    fun validarConexioninternet(contexto: Context): Boolean {
        val cm = contexto.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }



}