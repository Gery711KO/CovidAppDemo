package hu.kocsisgeri.bitraptors.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotifyingLinearLayoutManager(context: Context) : LinearLayoutManager(context, VERTICAL, false) {
    var mCallback: OnLayoutCompleteCallback? = null

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        mCallback?.onLayoutComplete()
    }

    fun isLastItemCompletelyVisible() = findLastCompletelyVisibleItemPosition() == itemCount - 1

    interface OnLayoutCompleteCallback {
        fun onLayoutComplete()
    }
}