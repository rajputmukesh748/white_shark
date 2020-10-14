# Permission Handler in android
# Mukesh Rajput

Hello Every One
Mostly new developers not used a proper runtime permission and not handle it.Overcome this issue create a new library is Permission library.
You can just create a valiable for permission class and override a permssion response handle and in onRequestPermissionsResult overide method call a {permission_class_variable}.onRequestPermissionsResult.

You can see all error and permissions are handled in grant permission or reject permissions.
<b><h1>Source Code</h1></b>
<b><h3>Create a variable for handle a permission grant or reject</h3></b>


    //Check Permission and handle a call backs
    //Must need to import that otherwise its not working :-  
    import com.test.permissions.permissions.Permissions
    
    
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




<b><h4>Call a onRequestPermissionsResult</h4></b>

      override fun onRequestPermissionsResult(
              requestCode: Int,
              permissions: Array<out String>,
              grantResults: IntArray
          ) {
              super.onRequestPermissionsResult(requestCode, permissions, grantResults)
              //Pass a onRequestPermissionResult to a permission class and it gives back in a permission variable overrided methods
              permission.onRequestPermissionsResult(
                  permissions.toList(),
                  grantResults.toList()
              )
          }


<b><h4>Create a permission list which you needed.</h4></b>
<p>Firstly add this permission in your manifest file. you can handle any permission just you can add in manifest file and add in array list</p>

<h5>Manifest File Permission Example</h5>

    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />


<h5>Create a permission list variable</h5>

    private val permissionList = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.CHANGE_WIFI_STATE
    )



<b><h4>Check Permission Grant or not</h4></b>
<p>Check permission grant or not if permission granted then you can handle over code according to recuirement otherwise again call a request permission function</p>
   
   <h5>Check permissions and call permissions for activity</h5>
   
        private fun checkPermissions() {
            try {
                if (permission.hasPermission(*permissionList)) {
                    Log.e("ndksndks", "msdmc")
                    //Do Your Code
                } else {
                    //wifiList is that list which you can creater in up variable
                    permission.request(*permissionList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        
        
<h5>Check permissions and call permissions for fragment</h5>
            
            private fun checkPermissions() {
                try {
                    if (permission.hasPermission(*permissionList)) {
                        Log.e("ndksndks", "msdmc")
                    } else {
                        //wifiList is that list which you can creater in up variable
                        
                       //for fragment you pass this or if you use a MVVM or other architecture then just simply pass a fragment instance 
                   
                        permission.request(this, *permissionList)
                                   
                                   OR
                        //For Mvvm or Other architecture
                        permission.request(framentInstance, *permissionList)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        
        
        
<h4>Implementation or add in grable file in android</h4>
<p>Add it in your root build.gradle at the end of repositories:</p>

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
 
<p>Add the dependency:</p>

implementation 'com.github.rajputmukesh748:white_shark:1.2.0'



<h5>Final Comments</h5>
    
    1) Hope this library helps to reduce your code and make easy for implementation.
    2) If any issue occur then please let me know and comment it definatly it will resolve with latest versions. 
    3) It's working in all android devices.
    4) Just you can add a any type of runtime permission in list and pass it will automatically check and resturn a list in overrided methods.
    5) It's Easy to use and no need for create a more classes and hanlde a code.
    
    
<b><h3>Thanks for your support. Please try and support it.</h3></b>

