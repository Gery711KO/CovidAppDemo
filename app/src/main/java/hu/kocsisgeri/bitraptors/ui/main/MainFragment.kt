package hu.kocsisgeri.bitraptors.ui.main

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import hu.kocsisgeri.bitraptors.databinding.FragmentMainBinding
import hu.kocsisgeri.bitraptors.ui.adapter.BasicListAdapter
import hu.kocsisgeri.bitraptors.ui.adapter.cell.cellPersonDelegate
import hu.kocsisgeri.bitraptors.ui.decoration.Decoration
import hu.kocsisgeri.bitraptors.ui.decoration.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModel()
    private val listAdapter = BasicListAdapter(cellPersonDelegate())
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
        binding.viewRC.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            addItemDecoration(decoration)
        }

        viewModel.covids.observe(viewLifecycleOwner) {
            // Set list items
            //message.text = it.toString()
            listAdapter.updateData(it)
        }

        viewModel.vaccinated.observe(viewLifecycleOwner) {
            vaccinated_text.text = it.toString()
        }

        viewModel.maxId.observe(viewLifecycleOwner) {
            dead_text.text = it.toString()
        }
    }
}