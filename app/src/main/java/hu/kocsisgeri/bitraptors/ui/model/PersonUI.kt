package hu.kocsisgeri.bitraptors.ui.model

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.ui.adapter.ListItem

data class PersonUI(
    val person: Person,
    val isOpened: Boolean
) : ListItem