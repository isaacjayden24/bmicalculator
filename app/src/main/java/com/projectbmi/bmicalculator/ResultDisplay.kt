package com.projectbmi.bmicalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.projectbmi.bmicalculator.model.bmiViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ResultDisplay.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultDisplay : Fragment() {

    private val counterViewModel: bmiViewModel by activityViewModels()


    private lateinit var healthBtn:Button
    //reference for text views
    private lateinit var bmiDisplay: TextView
    private lateinit var genderDisplay: TextView
    private lateinit var weightDisplay: TextView
    private lateinit var heightDisplay:TextView
    private lateinit var ageDisplay:TextView
    private lateinit var healthyWeightForTheHeight:TextView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view= inflater.inflate(R.layout.fragment_result_display, container, false)
        healthBtn=view.findViewById(R.id.healthBtn)
        //textview reference for the bmi result display
        bmiDisplay=view.findViewById(R.id.bmiDisplay)
        genderDisplay=view.findViewById(R.id.genderDisplay)

        weightDisplay=view.findViewById(R.id.weightDisplay)
        heightDisplay=view.findViewById(R.id.heightDisplay)
        ageDisplay=view.findViewById(R.id.ageDisplay)
        healthyWeightForTheHeight=view.findViewById(R.id.healthyWeightForTheHeight)




        //live data for the color for the text views
        counterViewModel.bmiColor.observe(viewLifecycleOwner) { colorRes ->
            bmiDisplay.setTextColor(ContextCompat.getColor(requireContext(), colorRes))
            weightDisplay.setTextColor(ContextCompat.getColor(requireContext(), colorRes))
            heightDisplay.setTextColor(ContextCompat.getColor(requireContext(), colorRes))
            ageDisplay.setTextColor(ContextCompat.getColor(requireContext(), colorRes))
            genderDisplay.setTextColor(ContextCompat.getColor(requireContext(), colorRes))
            healthyWeightForTheHeight.setTextColor(ContextCompat.getColor(requireContext(), colorRes))
        }


        // weight range live data observation

        counterViewModel.weightRange.observe(viewLifecycleOwner,Observer{weightRange ->
            healthyWeightForTheHeight.text=weightRange

        })

        counterViewModel.bmidisplay.observe(viewLifecycleOwner, Observer { bmidisplay ->
            bmiDisplay.text = bmidisplay.toString()
        })

        counterViewModel.weightdisplay.observe(viewLifecycleOwner, Observer { weightdisplay ->
            weightDisplay.text = weightdisplay.toString()
        })


        counterViewModel.heightdisplay.observe(viewLifecycleOwner, Observer { heightdisplay ->
            heightDisplay.text = heightdisplay.toString()
        })

        counterViewModel.agedisplay.observe(viewLifecycleOwner, Observer { agedisplay ->
            ageDisplay.text = agedisplay.toString()
        })




        counterViewModel.genderdisplay.observe(viewLifecycleOwner, Observer { genderdisplay ->
            genderDisplay.text = genderdisplay.toString()
        })





        healthBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_resultDisplay2_to_healthyDietTipsFragment2)
        }






        return view
    }




}