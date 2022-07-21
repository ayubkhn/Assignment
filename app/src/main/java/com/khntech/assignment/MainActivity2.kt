package com.khntech.assignment


import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
class MainActivity2 : AppCompatActivity() {

    private val REQUEST_CODE_ENABLE_BT: Int = 1

    private lateinit var bAdapter: BluetoothAdapter
    lateinit var nameShow: TextView
    lateinit var numShow: TextView
    lateinit var devices: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bAdapter = BluetoothAdapter.getDefaultAdapter()
        nameShow = findViewById(R.id.nameTxtShow)
        numShow = findViewById(R.id.numTxtShow)
        devices = findViewById(R.id.devices)
        loadData()
    }

    private fun loadData() {
        val my2Prefer = getSharedPreferences("KEY", Context.MODE_PRIVATE)
        val name = my2Prefer.getString("name", null)
        nameShow.text = name.toString()
        val num = my2Prefer.getLong("num", 0)
        numShow.text = num.toString()
    }

    fun scan(view: View) {

        if (bAdapter.isEnabled) {
            Toast.makeText(this, "Scanning", Toast.LENGTH_SHORT).show()
            val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
             devices.text = filter.toString()


        } else {
            val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(intent, REQUEST_CODE_ENABLE_BT)
        }

    }
}
