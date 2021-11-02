package com.afshinshahriarifahliani.photogallery.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.afshinshahriarifahliani.photogallery.databinding.FragmentHomeBinding
import com.afshinshahriarifahliani.photogallery.presentation.di.Injector
import com.afshinshahriarifahliani.photogallery.presentation.photo.PhotoAdapter
import com.afshinshahriarifahliani.photogallery.presentation.photo.PhotoViewModel
import com.afshinshahriarifahliani.photogallery.presentation.photo.PhotoViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: PhotoViewModelFactory
    private lateinit var photoViewModel: PhotoViewModel

    private lateinit var adapter: PhotoAdapter

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        (activity?.application as Injector).createPhotoSubComponent()
            .inject(this)

        photoViewModel = ViewModelProvider(this, factory)
            .get(PhotoViewModel::class.java)
        initRecyclerView()
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.photoRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = PhotoAdapter()
        binding.photoRecyclerView.adapter = adapter
        displayPhotos()
    }

    private fun displayPhotos() {
        binding.photoProgressBar.visibility = View.VISIBLE
        val responseLiveData = photoViewModel.getAllPhotos()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.photoProgressBar.visibility = View.GONE
            } else {
                binding.photoProgressBar.visibility = View.GONE
                Toast.makeText(activity?.applicationContext, "No data available", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }


}