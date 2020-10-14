package com.test.permissions.permissions

interface OnPermissionListener {

    fun onAllPermissionsGranted(permissions: List<String?>)

    fun onPermissionsGranted(permissions: List<String?>)

    fun onPermissionsDenied(permissions: List<String?>)

}