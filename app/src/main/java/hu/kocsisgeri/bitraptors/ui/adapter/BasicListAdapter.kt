package hu.kocsisgeri.bitraptors.ui.adapter

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import timber.log.Timber

open class BasicListAdapter(
    vararg adapters: AdapterDelegate<List<ListItem>>
) : ListDelegationAdapter<List<ListItem>>(*adapters){

    val listItems: List<ListItem> get() = items
    val itemsCount: Int get() = itemCount

    init {
        items = emptyList()
    }

    fun updateData(list: List<ListItem>) {
        items = list
        try {
            notifyDataSetChanged()
        } catch (e: IllegalStateException) {
            // strange error: Cannot call this method while RecyclerView is computing a layout or scrolling RecyclerView
            Timber.e(e, "Failed to update list")
        }
    }
    fun notifyItemUpdate(pos: Int) {
        notifyItemChanged(pos)
    }
    fun addDelegates(vararg delegates: AdapterDelegate<List<ListItem>>) {
        delegates.forEach {
            delegatesManager.addDelegate(it)
        }
    }
    fun setFallbackDelegate(delegate: AdapterDelegate<List<ListItem>>) {
        delegatesManager.fallbackDelegate = delegate
    }
}