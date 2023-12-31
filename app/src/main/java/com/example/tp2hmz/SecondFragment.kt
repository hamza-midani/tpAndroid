package com.example.tp2hmz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tp2hmz.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val x : SecondFragmentArgs by navArgs()
        val newText = getString(R.string.random_heading ,x.nn)
        binding.textviewHeader.text = newText

        val random = java.util.Random()
        var randomNumber = 0
        if (x.nn > 0) {
            randomNumber = random.nextInt(x.nn + 1)
        }
        binding.textviewRandom.text = randomNumber.toString()





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}