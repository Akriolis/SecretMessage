package com.akrio.secretmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController

class MessageFragment : Fragment() {

    private lateinit var nextButton: Button
    private lateinit var messageView: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_message, container, false)

        nextButton = view.findViewById(R.id.next)
        messageView = view.findViewById(R.id.message)

        nextButton.setOnClickListener {
            val message = messageView.text.toString()

            if(messageView.text.trim().isEmpty()){
                val toast = Toast.makeText(requireContext(), getString(R.string.invalid_input), Toast.LENGTH_LONG)
                toast.show()
            } else{
                val action = MessageFragmentDirections
                    .actionMessageFragmentToEncryptFragment(message)
                view.findNavController().navigate(action)
            }

        }
        return view
    }

}