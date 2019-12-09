package com.plads.testglide.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.plads.testglide.R
import com.plads.testglide.presentation.adapter.ImagesAdapter
import com.plads.testglide.presentation.viewmodel.ImageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewModel: ImageViewModel
    private var adapter = ImagesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
        setupRecyclerview()

        imageViewModel.images.observe(this, Observer {
            it?.let {
                adapter.renderables = it
            }
        })

        imageViewModel.getImages()
    }

    private fun setupRecyclerview() {
        rv_images.layoutManager = GridLayoutManager(this, 3)
        rv_images.adapter = adapter
    }
}
