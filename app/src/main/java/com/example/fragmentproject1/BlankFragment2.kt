package com.example.fragmentproject1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentproject1.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {
            binding.tvMessage2.text = it
        })
        binding.btnSendMessage2.setOnClickListener {
            dataModel.messageForFrag1.value = "hello from frag 2"
        }
        binding.btnSendToActivity2.setOnClickListener {
            dataModel.messageForActivity.value = "hello activity from frag2"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment2()

    }
}