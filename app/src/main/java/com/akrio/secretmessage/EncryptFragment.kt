package com.akrio.secretmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EncryptFragment : Fragment() {

    private lateinit var encryptedView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        encryptedView = view.findViewById(R.id.encrypted_message)

        val message = EncryptFragmentArgs.fromBundle(requireArguments()).message
        encryptedView.text = message.reversed()
        return view
    }
}