package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmicalculator.adapter.HealthyTipsAdapter
import com.example.bmicalculator.data.DataSource
import com.example.bmicalculator.databinding.FragmentHealthyDietTipsBinding
import com.example.bmicalculator.model.Healthy

class HealthyDietTipsFragment : Fragment() {
    private var _binding: FragmentHealthyDietTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Any initial setup can go here, if needed
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using DataBindingUtil
        _binding = FragmentHealthyDietTipsBinding.inflate(inflater, container, false)

        // List of healthy tips from the DataSource
        val tipsList: List<Healthy> = DataSource.tips

        // Initialize the adapter with the tips list
        val adapter = HealthyTipsAdapter(tipsList)
        binding.recyclerViewTips.adapter = adapter

        // Set the layout manager for the RecyclerView
        binding.recyclerViewTips.layoutManager = LinearLayoutManager(requireContext())

        // Return the root view of the binding
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}
