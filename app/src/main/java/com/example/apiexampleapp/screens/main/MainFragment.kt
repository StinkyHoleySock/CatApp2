package com.example.apiexampleapp.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apiexampleapp.R
import com.example.apiexampleapp.databinding.FragmentMainBinding
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.BannerAdSize
import com.huawei.hms.ads.HwAds
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(R.layout.fragment_main) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getCat()

        val binding = FragmentMainBinding.inflate(inflater, container, false)

        // Navigate to dialog fragment
        binding.toolbar.btnInfo.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_dialogFragment)
        }


        // Initialize the HUAWEI Ads SDK.
        HwAds.init(context)

        val bannerView = binding.hwBannerView

        // testw6vs28auh3 is a dedicated test ad unit ID.
        bannerView.adId = "testw6vs28auh3"

        bannerView.bannerAdSize = BannerAdSize.BANNER_SIZE_SMART

        // Add BannerView to the layout.
        val adParam = AdParam.Builder().build()
        bannerView.loadAd(adParam)


        viewModel.cat.observe(viewLifecycleOwner) { list ->
            list.body()?.let {
                Picasso.with(context)
                    .load(it[0].url)
                    .into(iv_cat)
            }
        }

        val memes = resources.getStringArray(R.array.memes)

        binding.btnRefresh.setOnClickListener {

            viewModel.getCat()

            val random = (memes.indices).random()
            tv_mem.text = memes[random]
        }

        return binding.root
    }
}