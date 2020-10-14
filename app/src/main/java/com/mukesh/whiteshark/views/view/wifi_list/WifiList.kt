package com.mukesh.whiteshark.views.view.wifi_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mukesh.whiteshark.databinding.WifiListBinding

class WifiList : Fragment() {

    private lateinit var wifiListBinding: WifiListBinding
    private val wifiListFactory by lazy { WifiListFactory(requireContext(), this) }
    private val wifiListViewModel by lazy {
        ViewModelProvider(this, wifiListFactory).get(
            WifiListViewModel::class.java
        )
    }


    /**
     * onCreateView Method Call
     * Initialize binding
     * */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        wifiListBinding = WifiListBinding.inflate(inflater)
        return wifiListBinding.root
    }


    /**
     * onViewCreated Method Call
     * for initialize view model
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wifiListBinding.wifiListVM = wifiListViewModel
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        wifiListViewModel.permission.onRequestPermissionsResult(
            permissions.toList(),
            grantResults.toList()
        )
    }

}