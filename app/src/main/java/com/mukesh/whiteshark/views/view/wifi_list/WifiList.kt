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
    private val wifiListFactory by lazy { WifiListFactory(requireContext()) }
    private val wifiListViewModel by lazy {
        ViewModelProvider(this, wifiListFactory).get(
            WifiListViewModel::class.java
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        wifiListBinding = WifiListBinding.inflate(inflater)
        return wifiListBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wifiListBinding.wifiListVM = wifiListViewModel
    }
}