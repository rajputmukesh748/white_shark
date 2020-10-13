package com.mukesh.whiteshark.views.view.main_page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mukesh.whiteshark.R
import com.mukesh.whiteshark.databinding.MainPageBinding

class MainPage : AppCompatActivity() {

    private val mainPageFactory by lazy { MainPageFactory(this) }
    private val mainPageViewModel: MainPageViewModel by lazy {
        ViewModelProvider(this, mainPageFactory).get(
            MainPageViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainPageBinding: MainPageBinding =
            DataBindingUtil.setContentView(this, R.layout.main_page)
        mainPageBinding.mainPageVM = mainPageViewModel
    }

}