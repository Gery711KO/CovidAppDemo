package hu.kocsisgeri.bitraptors.ui.model

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.ui.adapter.ListItem

class PersonUI (val person: Person,
                val isOpened: Boolean) : ListItem {

}