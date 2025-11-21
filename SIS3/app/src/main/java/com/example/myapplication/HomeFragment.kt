package com.example.myapplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.navigate_destination_button);
        val msgBtn = view.findViewById<Button>(R.id.send_msg_btn)
        val field = view.findViewById<EditText>(R.id.editText)

        var message = "";
        msgBtn.setOnClickListener {
            message = field.text.toString()
        }

        btn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeDestToFlowStepOneDest(flowStepWord = message)
            findNavController().navigate(action)
        }
    }
}