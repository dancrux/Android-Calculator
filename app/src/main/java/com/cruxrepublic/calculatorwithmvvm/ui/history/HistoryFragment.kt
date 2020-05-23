package com.cruxrepublic.calculatorwithmvvm.ui.history

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.cruxrepublic.calculatorwithmvvm.R
import com.cruxrepublic.calculatorwithmvvm.databinding.HistoryFragmentBinding
import com.cruxrepublic.calculatorwithmvvm.storage.database.HistoryDatabase


class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: HistoryFragmentBinding = DataBindingUtil.inflate(
           inflater, R.layout.history_fragment, container,false
       )

        val application = requireNotNull(this.activity).application
        val dataSource = HistoryDatabase.getInstance(application).getCalcHistoryDao()

        val viewModelFactory = HistoryViewModelFactory(dataSource, application)

        val historyViewModel = ViewModelProviders.of(
            this, viewModelFactory).get(HistoryViewModel::class.java)

        binding.historyViewModel = historyViewModel

        binding.lifecycleOwner = this

        val args = HistoryFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "CalculationExpression: ${args.calculationExpression}, " +
                "CalculationResult: ${args.calculationResult}", Toast.LENGTH_LONG).show()

        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)

//    }

}
