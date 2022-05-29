package hu.kocsisgeri.bitraptors.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import hu.kocsisgeri.bitraptors.R
import hu.kocsisgeri.bitraptors.data.logic.isOnline
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.databinding.FragmentMainBinding
import hu.kocsisgeri.bitraptors.ui.adapter.DiffListAdapter
import hu.kocsisgeri.bitraptors.ui.adapter.NotifyingLinearLayoutManager
import hu.kocsisgeri.bitraptors.ui.adapter.cell.cellEmptyDelegate
import hu.kocsisgeri.bitraptors.ui.adapter.cell.cellPersonDelegate
import hu.kocsisgeri.bitraptors.ui.decoration.ItemOffsetDecoration
import hu.kocsisgeri.bitraptors.ui.filter.FilterFragment
import hu.kocsisgeri.bitraptors.ui.model.EmptyUI
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModel()
    private val listAdapter = DiffListAdapter()
    private val decoration = ItemOffsetDecoration()
    private val filter = FilterFragment()
    private var isError = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()
        setupOther()
        setupSwipeToRefresh()
        setupCovidsObserver()
        setupDataLoadedObserver()
        setupFilterObserver()
    }

    private fun setupCovidsObserver() {
        viewModel.covids.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    Timber.d("DEBUG: SUCCESS")
                    listAdapter.updateData(it.data)
                    binding.caseCount.text = it.data.size.toString()
                    binding.motionDownload.transitionToStart()
                    binding.progressBar.visibility = View.GONE
                    binding.caseCount.visibility = View.VISIBLE
                    binding.caseCount.text = it.data.size.toString()
                    if (!binding.viewRC.isComputingLayout) {
                        binding.motionLayout.transitionToStart()
                    }
                    if (isError) {
                        listAdapter.addItem(EmptyUI())
                    }
                    binding.swipeToRefresh.isRefreshing = false
                    isError = binding.progressBar.progress != 100
                }
                is ApiResult.Progress -> {
                    Timber.d("DEBUG: PROGRESS")
                    listAdapter.updateData(listOf())
                    binding.caseCount.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                    binding.motionDownload.transitionToEnd()
                    binding.progressBar.progress = it.percentage
                    binding.swipeToRefresh.isRefreshing = false
                    isError = false
                }
                is ApiResult.Error -> {
                    Timber.d("DEBUG: ERROR")
                    binding.motionDownload.transitionToStart()
                    binding.progressBar.visibility = View.GONE
                    binding.swipeToRefresh.isRefreshing = false
                    isError = true
                }
            }
        }
    }

    private fun setupDataLoadedObserver() {
        viewModel.dataLoaded.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Success -> {
                    binding.vaccinatedText.text = it.data.vaccinated
                    binding.deadText.text = it.data.maxId
                    binding.swipeToRefresh.isRefreshing = false
                    binding.motionInternet.transitionToStart()
                    binding.motionData.transitionToEnd()
                }
                is ApiResult.Error -> {
                    binding.motionData.transitionToStart()
                    binding.motionInternet.transitionToEnd()
                    binding.swipeToRefresh.isRefreshing = false
                }
            }
        }
    }

    private fun setupSwipeToRefresh() {
        binding.swipeToRefresh.setProgressBackgroundColorSchemeColor(Color.rgb(14, 14, 14))
        binding.swipeToRefresh.setColorSchemeColors(Color.rgb(218, 218, 218))
        binding.swipeToRefresh.setOnRefreshListener {
            Timber.d("DEBUG: SWIPETOREFRESH - loading: ${!loadingData()} - $isError")
            if (!loadingData() || isError) {
                if (isOnline(context)) {
                    viewModel.refreshFunc()
                    if (isError) {
                        binding.motionDownload.transitionToEnd()
                        binding.progressBar.visibility = View.VISIBLE
                    }
                } else {
                    binding.swipeToRefresh.isRefreshing = false
                }
            }
        }
    }
    private fun setupList() {
        listAdapter.addDelegates(cellPersonDelegate { viewModel.selected.tryEmit(it)})
        listAdapter.addDelegates(cellEmptyDelegate())
        binding.viewRC.apply {
            layoutManager = NotifyingLinearLayoutManager(context)
            adapter = listAdapter
            addItemDecoration(decoration)
        }
        (binding.viewRC.layoutManager as NotifyingLinearLayoutManager).mCallback = object : NotifyingLinearLayoutManager.OnLayoutCompleteCallback {
            override fun onLayoutComplete() {
                if (isError) {
                    binding.viewRC.smoothScrollToPosition(0)
                }
                fabEnterAnimation()
                binding.motionLayout.transitionToStart()
            }
        }
    }

    private fun setupFilterObserver() {
        viewModel.filtering.observe(viewLifecycleOwner) {
            fabExitAnimation()
            binding.motionLayout.transitionToEnd()
        }
    }

    private fun fabExitAnimation() {
        binding.fab.animate().translationX(300f).apply {
            duration = 300
        }.start()
        binding.scrollToTop.animate().translationX(300f).apply {
            duration = 300
        }.start()
    }

    private fun fabEnterAnimation() {
        binding.fab.animate().translationX(0f).apply {
            duration = 300
        }.start()
        binding.scrollToTop.animate().translationX(0f).apply {
            duration = 300
        }.start()
    }

    private fun setupOther() {
        binding.fab.setOnClickListener {
            if (childFragmentManager.fragments.size == 0) {
                filter.show(childFragmentManager, FilterFragment.TAG)
            }
        }

        binding.scrollToTop.setOnClickListener {
            binding.viewRC.scrollToPosition(0)
        }
        binding.motionLayout.jumpToState(R.id.start)
        binding.motionLayout.setTransitionListener(object: MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {}
            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {}
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == motionLayout?.startState) {
                    binding.viewRC.scrollToPosition(0)
                }
            }
            override fun onTransitionTrigger(motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {}
        })
    }

    override fun onResume() {
        super.onResume()

        if (!loadingData()) {
            viewModel.refreshFunc()
        }
    }

    private fun loadingData() : Boolean {
        return !(binding.progressBar.progress == binding.progressBar.max || binding.progressBar.progress == 0)
    }
}