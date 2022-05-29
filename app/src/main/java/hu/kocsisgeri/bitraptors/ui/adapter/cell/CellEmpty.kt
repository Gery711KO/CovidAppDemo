package hu.kocsisgeri.bitraptors.ui.adapter.cell

import android.annotation.SuppressLint
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginTop
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import hu.kocsisgeri.bitraptors.databinding.CellEmptyBinding
import hu.kocsisgeri.bitraptors.ui.adapter.ListItem
import hu.kocsisgeri.bitraptors.ui.model.EmptyUI

@SuppressLint("UseCompatLoadingForDrawables")
fun cellEmptyDelegate() =
    adapterDelegateViewBinding<EmptyUI, ListItem, CellEmptyBinding>(
        viewBinding = { layoutInflater, root ->
            CellEmptyBinding.inflate(layoutInflater, root, false)
        },
        block = {}
    )