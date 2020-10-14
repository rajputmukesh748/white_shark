package com.mukesh.whiteshark.views.view.main_page

import android.Manifest
import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.test.permissions.permissions.OnPermissionListener
import com.test.permissions.permissions.Permissions

class MainPageViewModel(var context: Context) : ViewModel() {

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
    private val permission = Permissions(context as Activity,
        object : OnPermissionListener {
            override fun onAllPermissionsGranted(permissions: List<String?>) {
                //When all permission granted
                Log.e("All Permission :- ", "$permissions")
            }

            override fun onPermissionsGranted(permissions: List<String?>) {
                //When some permission granted
                Log.e("Granted Permissions :- ", "$permissions")
            }

            override fun onPermissionsDenied(permissions: List<String?>) {
                //when some permissions rejected
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
                //Do your code and handle it
            } else {
                //For Activity
                permission.request(*permissionList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}