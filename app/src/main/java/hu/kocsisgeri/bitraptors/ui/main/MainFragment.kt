package hu.kocsisgeri.bitraptors.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.databinding.FragmentMainBinding
import hu.kocsisgeri.bitraptors.ui.adapter.DiffListAdapter
import hu.kocsisgeri.bitraptors.ui.adapter.cell.cellPersonDelegate
import hu.kocsisgeri.bitraptors.ui.decoration.ItemOffsetDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModel()
    private val listAdapter = DiffListAdapter(cellPersonDelegate { viewModel.selected.tryEmit(it) })
    private val decoration = ItemOffsetDecoration()
    private val filter = FilterFragment()

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

        binding.fab.setOnClickListener {
            filter.show(childFragmentManager, FilterFragment.TAG)
        }

        binding.scrollToTop.setOnClickListener {
            binding.viewRC.scrollToPosition(0)
        }

        viewModel.covids.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    listAdapter.updateData(it.data)
                    binding.viewRC.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    binding.internetConnectionText.visibility = View.GONE
                    binding.caseCount.text = it.data.size.toString()
                }
                is ApiResult.Progress -> {
                    binding.progressBar.progress = it.percentage
                }
                is ApiResult.Error -> {
                    binding.internetConnectionText.visibility = View.VISIBLE
                }
            }
        }

        viewModel.vaccinated.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    binding.vaccinatedText.text = it.data
                    binding.progressCircle.visibility = View.GONE
                    binding.vaccinatedLayout.visibility = View.VISIBLE
                }
                is ApiResult.Error -> {
                    binding.internetConnectionText.visibility = View.VISIBLE
                }
            }
        }

        viewModel.maxId.observe(viewLifecycleOwner) {

            when (it) {
                is ApiResult.Success -> {
                    binding.deadText.text = it.data
                    binding.progressCircle.visibility = View.GONE
                    binding.deadLayout.visibility = View.VISIBLE
                }
                is ApiResult.Error -> {
                    binding.internetConnectionText.visibility = View.VISIBLE
                }
            }
        }
    }
}