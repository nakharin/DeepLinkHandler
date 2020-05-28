package com.nakharin.pocdeeplink.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nakharin.pocdeeplink.databinding.ActivityFoodBinding
import com.nakharin.pocdeeplink.shared.deeplink.command.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData

class FoodActivity : AppCompatActivity() {

    private val binding: ActivityFoodBinding by lazy { ActivityFoodBinding.inflate(layoutInflater) }

    private var restaurantId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent?.let {
            handleIntent(it)
        }
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
        val mainDeeplinkData = intent.getParcelableExtra<FoodDeeplinkData>(DeeplinkCommand.EXTRA_DEEP_LINK_KEY)
        mainDeeplinkData?.let {
            restaurantId = it.restaurantId ?: ""
            updateUI()
        }
    }

    private fun updateUI() {
        binding.foodTxtTitle.text = "restaurantId: $restaurantId"
    }
}
