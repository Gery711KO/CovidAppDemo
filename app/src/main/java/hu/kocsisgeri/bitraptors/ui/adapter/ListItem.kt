package hu.kocsisgeri.bitraptors.ui.adapter

interface ListItem {
    fun getAdapterItemId(): String = this::class.java.name
    fun getAdapterItemHash(): Int = hashCode()
}