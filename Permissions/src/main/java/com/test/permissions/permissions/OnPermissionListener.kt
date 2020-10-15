package com.test.permissions.permissions

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

interface OnPermissionListener {

    fun onAllPermissionsGranted(permissions: List<String?>)

    fun onPermissionsGranted(permissions: List<String?>)

    fun onPermissionsDenied(permissions: List<String?>)

}