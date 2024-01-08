package com.example.android3_hw8


import android.os.Build
import android.os.Bundle
import java.io.Serializable

fun <T : Serializable?> getSerializable(bundle: Bundle, name: String, clazz: Class<T>): T
{
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        bundle.getSerializable(name, clazz)!!
    else
        bundle.getSerializable(name) as T
}