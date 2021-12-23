package hu.kocsisgeri.bitraptors.ui.adapter.cell

import android.annotation.SuppressLint
import android.view.View
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import hu.kocsisgeri.bitraptors.R
import hu.kocsisgeri.bitraptors.databinding.CellPersonBinding
import hu.kocsisgeri.bitraptors.ui.adapter.ListItem
import hu.kocsisgeri.bitraptors.ui.model.PersonUI

@SuppressLint("UseCompatLoadingForDrawables")
fun cellPersonDelegate(select: (Int) -> Unit) =
    adapterDelegateViewBinding<PersonUI, ListItem, CellPersonBinding>(
        viewBinding = { layoutInflater, root ->
            CellPersonBinding.inflate(layoutInflater, root, false)
        },
        block = {
            binding.root.setOnClickListener {
                if (item.isOpened) {
                    select(0)
                } else {
                    select(item.person.id)
                }
            }
            bind {
                if (item.isOpened) {
                    binding.pIllnessText.visibility = View.VISIBLE
                    binding.pIdText.background = context.getDrawable(R.drawable.rounded_left)
                    binding.pAgeText.background = context.getDrawable(R.drawable.rounded_right)
                } else {
                    binding.pIllnessText.visibility = View.GONE
                    binding.pIdText.background =
                        context.getDrawable(R.drawable.rounded_left_up_down)
                    binding.pAgeText.background =
                        context.getDrawable(R.drawable.rounded_right_up_down)
                }

                binding.pIdText.text = item.person.id.toString()
                binding.pSexText.text = item.person.sex
                binding.pAgeText.text = item.person.age.toString().plus(" éves")
                binding.pIllnessText.text = item.person.baseIllnesses
            }
        }
    )