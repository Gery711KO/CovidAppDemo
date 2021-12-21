package hu.kocsisgeri.bitraptors.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import hu.kocsisgeri.bitraptors.databinding.FilterDialogBinding
import kotlinx.android.synthetic.main.filter_dialog.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilterFragment : BottomSheetDialogFragment() {
    companion object {
        fun newInstance() = FilterFragment()
    }

    lateinit var binding: FilterDialogBinding
    private val filterVM: FilterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilterDialogBinding.inflate(inflater, container, false)
        //getDialog()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filterButton.setOnClickListener {
            filterVM.filterButtonFunc(
                age_min.text.toString().let {
                    if (it.isNotEmpty()) {
                        it.toInt()
                    } else 0
                },
                age_max.text.toString().let {
                    if (it.isNotEmpty()) {
                        it.toInt()
                    } else 150
                },
                keyword.text.toString()
            )

            binding.filtersUsed.text = "[minAge: ${age_min.text}] [maxAge: ${age_max.text}] [keyWord: ${keyword.text}]"
        }

        binding.clearButton.setOnClickListener {
            filterVM.clearButtonFunc()

            binding.filtersUsed.text = ""
        }
        initDialog()
    }

    private fun initDialog() {
        requireDialog().window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        requireDialog().window?.statusBarColor =
            requireContext().getColor(android.R.color.transparent)
    }
}