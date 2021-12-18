package hu.kocsisgeri.bitraptors.ui.adapter.cell

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.databinding.CellPersonBinding
import hu.kocsisgeri.bitraptors.ui.adapter.ListItem

fun cellPersonDelegate() =
    adapterDelegateViewBinding<Person, ListItem, CellPersonBinding>(
        viewBinding = { layoutInflater, root ->
            CellPersonBinding.inflate(layoutInflater, root, false)
        },
        block = {
            bind {
                binding.pIdText.text = item.id.toString()
                binding.pSexText.text = item.sex
                binding.pAgeText.text = item.age.toString().plus(" éves")
            }
        }
    )