package com.example.recycleviewproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewproject.R
import com.example.recycleviewproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeChanges()

        return binding.root
    }


    private fun observeChanges() {
        viewModel.data.observe(viewLifecycleOwner) {

            layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.layoutManager = layoutManager
            adapter = RecyclerAdapter(it) { data, _ ->
                findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(data))
            }
            binding.recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}