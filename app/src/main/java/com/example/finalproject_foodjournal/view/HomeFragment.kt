package com.example.finalproject_foodjournal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject_foodjournal.databinding.HomeFragmentBinding
import com.example.finalproject_foodjournal.db.RepoFoodLog
import com.example.finalproject_foodjournal.db.db
import com.example.finalproject_foodjournal.vm.HomeViewModel
import com.example.finalproject_foodjournal.vm.FoodViewModelFactory

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = initViewModel()
        binding = initViewBinding(viewModel, inflater, container)
        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Home"
    }

    private fun initViewBinding(homeViewModel:HomeViewModel,
                                inflater: LayoutInflater,
                                container: ViewGroup?): HomeFragmentBinding {

        val bind = HomeFragmentBinding.inflate(inflater, container, false)
        bind.homeViewModel = homeViewModel
        bind.lifecycleOwner = viewLifecycleOwner

        return bind
    }

    private fun initViewModel(): HomeViewModel{
        val dao = requireActivity().let { db.getInstance(it).foodLogDao }
        val repo = RepoFoodLog(dao)
        val factory = FoodViewModelFactory(repo)

        return ViewModelProvider(this, factory).get(HomeViewModel::class.java)
    }

    private fun initRecyclerView(){
        binding.homeRecyclerview.layoutManager = LinearLayoutManager(activity)
        // TODO: display food log
    }
}