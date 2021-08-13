package com.androiddev.retrofit_offline.ui.songs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddev.retrofit_offline.R
import com.androiddev.retrofit_offline.data.entities.ResultModel
import com.androiddev.retrofit_offline.databinding.FragmentSongBinding
import com.androiddev.retrofit_offline.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SongFragment : Fragment() {

    private lateinit var binding: FragmentSongBinding
    private val viewModel: SongViewModel by viewModels()
    private lateinit var adapter: SongAdapter
    var search:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSongBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.btnSearch.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            getSongs()
        }
    }

    private fun getSongs() {
        search = binding.edtSearchSong.text.toString()
        if (search.isEmpty()) {
            Toast.makeText(context, "enter the artist/song name", Toast.LENGTH_SHORT)
                .show()
        }
        val ch = '+'
        search = search.replace(' ', ch)
        binding.edtSearchSong.text = null
        viewModel.getSong(search)
        setupObservers()


    }

    private fun setupRecyclerView() {
        adapter = SongAdapter()
        binding.rvSongsList.setHasFixedSize(true)
        binding.rvSongsList.layoutManager = GridLayoutManager(context,2)
        binding.rvSongsList.adapter = adapter
    }

    private fun setupObservers() {

        viewModel.song!!.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setData(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }




}