package com.trios2024amrk.swisschalet.ui.main

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.trios2024amrk.swisschalet.R
import com.trios2024amrk.swisschalet.databinding.FragmentMainBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    companion object {
        fun newInstance() = MenuFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.listsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.listsRecyclerview.adapter = ListSelectionRecyclerViewAdapter()
        return binding.root
    }

}