package hu.kocsisgeri.bitraptors.ui.adapter

import hu.kocsisgeri.bitraptors.data.dao.Person

interface ListItem {
    fun getAdapterItemId(): String = this::class.java.name
    fun getAdapterItemHash(): Int = hashCode()
}