package com.example.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.adapter.HealthyTipsAdapter
import com.example.bmicalculator.databinding.ActivityHealthyTipsBinding
import com.example.bmicalculator.model.Healthy
import com.example.bmicalculator.data.DataSource
import androidx.recyclerview.widget.LinearLayoutManager

class HealthyTipsActivity:AppCompatActivity()  {
    private lateinit var binding: ActivityHealthyTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthyTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  list of healthy tips called 'tipsList' from the DataSource
        val tipsList: List<Healthy> = DataSource.tips

        val adapter = HealthyTipsAdapter(tipsList)
        binding.recyclerViewTips.adapter = adapter

        // Set the layout manager ( LinearLayoutManager, GridLayoutManager, )
        binding.recyclerViewTips.layoutManager = LinearLayoutManager(this)

    }
}
