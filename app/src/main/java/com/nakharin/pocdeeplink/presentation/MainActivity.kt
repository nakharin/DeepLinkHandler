package com.nakharin.pocdeeplink.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nakharin.pocdeeplink.databinding.ActivityMainBinding
import com.nakharin.pocdeeplink.shared.NavigationHandler
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.model.MainDeeplinkModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val navigationHandler: NavigationHandler by inject()

    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent?.let {
            handleIntent(it)
        }

        initListener()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {
            handleIntent(it)
        }
    }

    private fun handleIntent(intent: Intent) {
        handleDeeplink(intent)
        intent.data?.let {
            // handle others
        }
    }

    private fun handleDeeplink(intent: Intent) {
        val mainDeeplinkModel = intent.getParcelableExtra<MainDeeplinkModel>(DeeplinkProcessor.DEEP_LINK_EXTRA_KEY)
        mainDeeplinkModel?.let {
            id = it.id ?: ""
            updateUI()
        }
    }

    private fun updateUI() {
        binding.mainTxtTitle.text = "id: $id"
    }

    private fun initListener() {
        binding.mainBtnGoToFood.setOnClickListener(onClickListener)
    }

    /*********************************************************************
     ******************************* Listener ****************************
     *********************************************************************/

    private val onClickListener: (v: View) -> Unit = {
        if (it == binding.mainBtnGoToFood) {
            startActivity(navigationHandler.buildFoodActivity())
        }
    }
}
