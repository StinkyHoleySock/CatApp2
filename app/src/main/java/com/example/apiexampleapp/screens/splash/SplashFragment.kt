package com.example.apiexampleapp.screens.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apiexampleapp.R
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment: Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_splash.setOnClickListener {

            // Start animation
            splashFragment.transitionToEnd()

            // Start mainFragment
            view.postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment)},
                1000)
        }

    }

}