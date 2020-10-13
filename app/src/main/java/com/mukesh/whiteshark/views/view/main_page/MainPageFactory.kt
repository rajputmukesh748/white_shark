package com.mukesh.whiteshark.views.view.main_page

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mukesh.whiteshark.R

class MainPageFactory(var context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainPageViewModel::class.java)) {
            return MainPageViewModel(context) as T
        }
        throw IllegalAccessException(context.getString(R.string.view_model_not_find))
    }
}