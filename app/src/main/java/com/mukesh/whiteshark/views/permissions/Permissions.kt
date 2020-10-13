package com.mukesh.whiteshark.views.permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class Permissions(
    private var activity: Activity,
    private var onPermissionListener: OnPermissionListener
) {

    fun onRequestPermissionsResult(permissions: List<String>, grantResult: List<Int>) {
        try {
            val grantedPermission: ArrayList<String> = ArrayList()
            val deniedPermission: ArrayList<String> = ArrayList()

            //Check All Permission and add in array list
            for (item in grantResult.indices) {
                if (item == PackageManager.PERMISSION_DENIED) {
                    deniedPermission.add(permissions[grantResult.indexOf(item)])
                } else {
                    grantedPermission.add(permissions[grantResult.indexOf(item)])
                }
            }

            if (grantedPermission.size == permissions.size) {
                onPermissionListener.onAllPermissionsGranted(permissions)
            } else {
                onPermissionListener.onPermissionsGranted(grantedPermission)
                onPermissionListener.onPermissionsDenied(deniedPermission)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    //Request Permission
    fun request(vararg permissions: String) {

        val permissionNeeded: MutableList<String> = ArrayList()

        for (permission in permissions) {

            if (ActivityCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permissionNeeded.add(permission)
            }
        }
        if (permissionNeeded.size > 0) {
            ActivityCompat.requestPermissions(activity, permissionNeeded.toTypedArray(), 10002)
        }
    }


    // Check has permission
    fun hasPermission(vararg permissions: String?): Boolean {
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(activity, permission!!)
                != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }

}