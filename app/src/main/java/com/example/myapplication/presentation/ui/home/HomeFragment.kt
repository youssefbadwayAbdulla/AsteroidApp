package com.example.myapplication.presentation.ui.home


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.domain.model.DataModel
import com.example.myapplication.presentation.ui.adapters.HomeAdapter
import com.example.myapplication.presentation.utils.downloadImage
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()))
    }
    private val viewModel: HomeViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel.getAllImage()
        viewModel.getAPIAllData()
        with(viewModel) {
            loadingLiveData.observe(viewLifecycleOwner) { binding.progressBar.isVisible = it }
            dataAPILiveData.observe(viewLifecycleOwner) { setupRecyclerView(it) }
            imageLiveData.observe(viewLifecycleOwner) { binding.ivPlaceholderPhoto.downloadImage(it) }
        }
    }


    private fun setupRecyclerView(listData: MutableList<DataModel>) {
        val adapter: HomeAdapter by lazy { HomeAdapter(listData, this) }
        adapter.setList(listData)
        binding.rvAsteroidView.adapter = adapter

    }

    override fun onClick(item: DataModel) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_items, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.view_week -> {
                viewModel.getDataWeekAndSaved()
                Toast.makeText(requireContext(), "asteroid  week", Toast.LENGTH_LONG).show()
            }
            R.id.view_day -> {
                viewModel.getDataDay()
                Toast.makeText(requireContext(), "asteroid day", Toast.LENGTH_LONG).show()
            }
            R.id.saved_week -> {
                viewModel.getDataWeekAndSaved()
                Toast.makeText(requireContext(), "asteroid saved", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}