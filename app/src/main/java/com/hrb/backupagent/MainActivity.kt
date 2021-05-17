package com.hrb.backupagent

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedpreferences =
            getSharedPreferences("sample", Context.MODE_PRIVATE)
        val data = sharedpreferences.getString("key", null)
        if (data == null) {
            writeData(sharedpreferences)
        } else {
            Log.d("From preference", data.toString())
        }

    }

    private fun writeData(sharedpreferences: SharedPreferences) {
        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        editor.putString("key", "value")
        editor.apply()
    }
}