package com.example.myapplication.presentation.ui.detials


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsFragment : Fragment() {
    private val viewModel: DetailsViewModel by sharedViewModel()

    private val binding: FragmentDetailsBinding by lazy {
        FragmentDetailsBinding.inflate(LayoutInflater.from(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.data = DetailsFragmentArgs.fromBundle(it).dataModel
        }
        binding.helpIcon.setOnClickListener {
            showMessageAlertDialog(getString(R.string.messageAlertDialog))
        }


    }

    private fun showMessageAlertDialog(showMessage: String) {
        AlertDialog.Builder(requireContext())
            .setMessage(showMessage)
            .setPositiveButton("Accept") { showDialog, double ->
                showDialog.dismiss()
            }
            .show()
    }
}