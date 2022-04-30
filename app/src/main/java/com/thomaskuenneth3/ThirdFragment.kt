package com.thomaskuenneth3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.slider.RangeSlider
import com.thomaskuenneth3.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: com.thomaskuenneth3.databinding.FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm: MyViewModel by viewModels()


        var edittext = binding.edittext1

        binding.button1.setOnClickListener {
            vm.clicked(edittext.text.toString())
            binding.text1.text = vm.name.value
        }

        binding.composeView1.apply {
            id = R.id.compose_view1
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Text("top", modifier = Modifier.background(MaterialTheme.colors.error))
            }
        }
        binding.composeView2.apply {
            id = R.id.compose_view2
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Text(
                    "bottom",
                    modifier = Modifier.background(MaterialTheme.colors.secondaryVariant)
                )
            }
        }

        binding.slider1.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: RangeSlider) {
                val values = binding.slider1.values
                //Those are the satrt and end values of sldier when user start dragging
            }

            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: RangeSlider) {
                val values = binding.slider1.values
                //Those are the new updated values of sldier when user has finshed dragging
                binding.text1.text = values[0].toString()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}