package com.example.myapplication

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

//    var layout = binding.mainroot
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission has been granted. Start camera preview Activity.
//                layout.showSnackbar(
//                    R.string.camera_permission_granted,
//                    Snackbar.LENGTH_INDEFINITE,
//                    R.string.ok
//                )
//                {
//                   // startCamera()
//                }
            } else {
                // Permission request was denied.
//                layout.showSnackbar(
//                    R.string.camera_permission_denied,
//                    Snackbar.LENGTH_SHORT,
//                    R.string.ok)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isThereBT()
        val button2 = binding.button2
        button2.setOnClickListener {
            val intent = Intent(this,CodingPermission::class.java)
            startActivity(intent)
        }
    }
    private fun isThereBT() {
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter

        if (bluetoothAdapter == null) {
            Toast.makeText(this,"Tidak mendukung bluetooth", Toast.LENGTH_SHORT).show()
            //binding.btnONOFF.isEnabled=false
            //binding.findBtn.isEnabled = false
            // binding.printBtn.isEnabled = false
            return

        }else
        {
            //ini ketika bluetooth di miliki oleh perangkat
            Toast.makeText(this,"Dukungan bluetooth tersedia", Toast.LENGTH_SHORT).show()
            //binding.printerStatTv.text = "Bluetooth Ready"
            //binding.printerStatTv.text = "Not Connected"

           // cekScanBTPermission()
            //cekForBTConPermision()
            cekBTpermission()

        }
    }

    private fun cekBTpermission() {
    }
    private fun showCameraPreview() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED) {
//            layout.showSnackbar(
//                R.string.camera_permission_available,
//                Snackbar.LENGTH_INDEFINITE,
//                R.string.ok
//            ) {
//                startCamera()
//            }
        } //else
            //requestCameraPermission()
    }
 private fun btConPermission(){
     if (ContextCompat.checkSelfPermission(this,Manifest.permission.BLUETOOTH_CONNECT)
         ==PackageManager.PERMISSION_GRANTED){

     }
 }


    private fun requestCameraPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.
//            layout.showSnackbar(
//                R.string.camera_access_required,
//                Snackbar.LENGTH_INDEFINITE,
//                R.string.ok
//            ) {
//                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
//            }
        } else {
            // You can directly ask for the permission.
//            layout.showSnackbar(
//                R.string.camera_permission_not_available,
//                Snackbar.LENGTH_LONG,
//                R.string.ok
//            ) {
//                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
//            }
        }
    }

}