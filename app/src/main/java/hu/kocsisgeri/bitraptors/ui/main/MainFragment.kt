package hu.kocsisgeri.bitraptors.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.databinding.FilterDialogBinding
import hu.kocsisgeri.bitraptors.databinding.FragmentMainBinding
import hu.kocsisgeri.bitraptors.ui.adapter.DiffListAdapter
import hu.kocsisgeri.bitraptors.ui.adapter.cell.cellPersonDelegate
import hu.kocsisgeri.bitraptors.ui.decoration.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.util.DisplayMetrics

import androidx.recyclerview.widget.LinearSmoothScroller




class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModel()
    private val listAdapter = DiffListAdapter(cellPersonDelegate())
    private val decoration = ItemOffsetDecoration()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewRC.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            addItemDecoration(decoration)
        }
        fab.setOnClickListener{
            FilterFragment.newInstance().show(childFragmentManager, FilterFragment::class.java.canonicalName)
        }

        scrollToTop.setOnClickListener{
            viewRC.scrollToPosition(0)
        }

        viewModel.covids.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    listAdapter.updateData(it.data)
                    viewRC.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    caseCount.text = it.data.size.toString()
                }
                is ApiResult.Progress -> {
                    progressBar.progress = it.percentage
                }
                is ApiResult.Error -> {
                    internetConnectionText.visibility = View.VISIBLE
                }
            }
        }

        viewModel.vaccinated.observe(viewLifecycleOwner) {
            when (it){
                is ApiResult.Success -> {
                    vaccinated_text.text = it.data
                    progressCircle.visibility = View.GONE
                    vaccinatedLayout.visibility = View.VISIBLE
                }
                is ApiResult.Error -> {
                    internetConnectionText.visibility = View.VISIBLE
                }
            }
        }

        viewModel.maxId.observe(viewLifecycleOwner) {

            when (it){
                is ApiResult.Success -> {
                    dead_text.text = it.data
                    progressCircle.visibility = View.GONE
                    deadLayout.visibility = View.VISIBLE
                }
                is ApiResult.Error -> {
                    internetConnectionText.visibility = View.VISIBLE
                }
            }
        }
    }
}