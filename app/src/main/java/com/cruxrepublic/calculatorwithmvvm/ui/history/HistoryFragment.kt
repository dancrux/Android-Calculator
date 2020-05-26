package com.cruxrepublic.calculatorwithmvvm.ui.history

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cruxrepublic.calculatorwithmvvm.R
import com.cruxrepublic.calculatorwithmvvm.databinding.HistoryFragmentBinding
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalcHistoryDao
import com.cruxrepublic.calculatorwithmvvm.storage.database.HistoryDatabase


class HistoryFragment : Fragment() {
    lateinit var binding: HistoryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
           inflater, R.layout.history_fragment, container,false
       )

        val application: Application = requireNotNull(this.activity).application
        val dataSource: CalcHistoryDao = HistoryDatabase.getInstance(application).getCalcHistoryDao()

        val viewModelFactory = HistoryViewModelFactory(dataSource, application)

        val historyViewModel = ViewModelProvider(
            this, viewModelFactory).get(HistoryViewModel::class.java)

        binding.historyViewModel = historyViewModel

        binding.lifecycleOwner = this




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.historyViewModel?.getAllCalculations()?.observe(viewLifecycleOwner, Observer {
            binding.textResult.text = it[0].calculationExpression
        })
    }
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)

//    }

}
