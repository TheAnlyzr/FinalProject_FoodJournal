package com.example.finalproject_foodjournal.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject_foodjournal.databinding.ReportFragmentBinding
import com.example.finalproject_foodjournal.db.RepoFoodLog
import com.example.finalproject_foodjournal.db.db
import com.example.finalproject_foodjournal.vm.FoodViewModelFactory
import com.example.finalproject_foodjournal.vm.HomeViewModel
import com.example.finalproject_foodjournal.vm.ReportViewModel

class ReportFragment : Fragment() {

    companion object {
        fun newInstance() = ReportFragment()
    }

    private lateinit var binding: ReportFragmentBinding
    private lateinit var viewModel: ReportViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = initViewModel()
        binding = initViewBinding(viewModel, inflater, container)
        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Report"
    }

    private fun initViewBinding(reportViewModel: ReportViewModel,
                                inflater: LayoutInflater,
                                container: ViewGroup?): ReportFragmentBinding {

        val bind = ReportFragmentBinding.inflate(inflater, container, false)
        bind.reportViewModel = reportViewModel
        bind.lifecycleOwner = viewLifecycleOwner

        return bind
    }

    private fun initViewModel(): ReportViewModel {
        val dao = requireActivity().let { db.getInstance(it).foodLogDao }
        val repo = RepoFoodLog(dao)
        val factory = FoodViewModelFactory(repo)

        return ViewModelProvider(this, factory).get(ReportViewModel::class.java)
    }

    private fun initRecyclerView(){
        // Ngebuat recycle view adapternya
        binding.reportRecylerview.layoutManager = LinearLayoutManager(activity)
        // TODO: display report log
    }
}