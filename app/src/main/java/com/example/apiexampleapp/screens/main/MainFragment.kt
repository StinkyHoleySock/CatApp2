package com.example.apiexampleapp.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apiexampleapp.NetworkConnection
import com.example.apiexampleapp.R
import com.example.apiexampleapp.databinding.FragmentMainBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(R.layout.fragment_main) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val binding = FragmentMainBinding.inflate(inflater, container, false)

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