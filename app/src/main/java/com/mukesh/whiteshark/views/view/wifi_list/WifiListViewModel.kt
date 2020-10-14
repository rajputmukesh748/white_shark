package com.mukesh.whiteshark.views.view.wifi_list

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.mukesh.whiteshark.views.permissions.OnPermissionListener
import com.mukesh.whiteshark.views.permissions.Permissions

class WifiListViewModel(private var context: Context, var wifiList: WifiList) : ViewModel() {

    /** Permission List */
    private val permissionList = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.CHANGE_WIFI_STATE
    )


    /**
     * Check Permissions
     * and handle a call backs
     * */
    val permission = Permissions(context as Activity,
        object : OnPermissionListener {
            override fun onAllPermissionsGranted(permissions: List<String?>) {
                Log.e("All Permission :- ", "$permissions")
            }

            override fun onPermissionsGranted(permissions: List<String?>) {
                Log.e("Granted Permissions :- ", "$permissions")
            }

            override fun onPermissionsDenied(permissions: List<String?>) {
                Log.e("Denied Permissions :- ", "$permissions")
            }

        })


    init {
        checkPermissions()
    }

    /**
     * Check Permissions
     * */
    private fun checkPermissions() {
        try {
            if (permission.hasPermission(*permissionList)) {
                Log.e("ndksndks", "msdmc")
            } else {
                permission.request(wifiList, *permissionList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * Get a WifiManager
     * for access all in build features
     * Prevent from Wifi Manager Leak
     * */
    @SuppressLint("WifiManagerLeak")
    val wifiManager = (context as Activity).getSystemService(Context.WIFI_SERVICE) as WifiManager


    /**
     * Create a wifi list
     * All Wifi scanned result
     * list created
     * */
    val scannedWifiList = ArrayList<ScanResult>()


    /**
     * Name {White Shark}
     * Author {Mukesh Rajput}
     * Wifi Receiver to get list of wifi
     * */
    private val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.e("Scanned Result Data", wifiManager.scanResults.toString())
            if (intent?.action == WifiManager.SCAN_RESULTS_AVAILABLE_ACTION) {
                scannedWifiList.addAll(wifiManager.scanResults)
            }
        }
    }


    /**
     * Name {White Shark}
     * Author {Mukesh Rajput}
     * Register Wifi Receiver
     * */
    fun registerReceiver() {
        try {
            LocalBroadcastManager.getInstance(context).registerReceiver(
                wifiReceiver,
                IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
            )
            wifiManager.startScan()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * Name {White Shark}
     * Author {Mukesh Rajput}
     * Unregister Wifi Receiver
     * */
    fun unregisterReceiver() {
        try {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(wifiReceiver)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}