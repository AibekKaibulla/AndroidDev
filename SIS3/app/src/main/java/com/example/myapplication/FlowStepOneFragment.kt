package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class FlowStepOneFragment : Fragment(R.layout.flow_step_one_fragment) {
    private val args: FlowStepOneFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receivedWord = args.flowStepWord

        val textView = view.findViewById<TextView>(R.id.flow_step_one_TextView)
        textView.text = receivedWord
    }
}