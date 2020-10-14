package com.mukesh.whiteshark.views.view.wifi_list

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mukesh.whiteshark.R

class WifiListFactory(var context: Context, var wifiList: WifiList) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WifiListViewModel::class.java)) {
            return WifiListViewModel(context, wifiList) as T
        }
        throw IllegalAccessException(context.getString(R.string.view_model_not_find))
    }
}