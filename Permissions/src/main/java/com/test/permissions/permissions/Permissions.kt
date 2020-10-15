package com.test.permissions.permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

/**
 * author {White Shark}
 * author {Mukesh Rajput}
 *
 * Mostly new developers not used a proper runtime permission
 * and not handle it.Overcome this issue create a new library
 * is Permission library.You can just create a variable for permission
 * class and override a permission response handle and in
 * onRequestPermissionsResult override method call a
 * {permission_class_variable}.onRequestPermissionsResult.
 *
 *
 * Go to github and get a latest version of code
 * implementation 'com.github.rajputmukesh748:white_shark:{latest_version_code}
 *
 * */

class Permissions(
    private var activity: Activity,
    private var onPermissionListener: OnPermissionListener
) {

    fun onRequestPermissionsResult(permissions: List<String>, grantResult: List<Int>) {
        try {
            val grantedPermission: ArrayList<String> = ArrayList()
            val deniedPermission: ArrayList<String> = ArrayList()

            //Check All Permission and add in array list
            for (i in permissions.indices) {
                if (grantResult[i] == PackageManager.PERMISSION_GRANTED) {
                    grantedPermission.add(permissions[i])
                } else {
                    deniedPermission.add(permissions[i])
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


    //Request Fragment Permission
    fun request(fragment: Fragment, vararg permissions: String) {

        val permissionNeeded: MutableList<String> = ArrayList()

        for (permission in permissions) {

            if (ActivityCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permissionNeeded.add(permission)
            }
        }
        if (permissionNeeded.size > 0) {
            fragment.requestPermissions(permissionNeeded.toTypedArray(), 10002)
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