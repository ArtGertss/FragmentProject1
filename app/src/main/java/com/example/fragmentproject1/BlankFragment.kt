package com.example.fragmentproject1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragmentproject1.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {
            binding.tvMessage1.text = it
        })
        binding.btnSendMessage.setOnClickListener {
            dataModel.messageForFrag2.value = "hello from frag 1"
        }
        binding.btnSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "hello activity from frag1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}