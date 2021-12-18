package hu.kocsisgeri.bitraptors.ui.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import hu.kocsisgeri.bitraptors.ui.adapter.BasicListAdapter

class ItemOffsetDecoration : RecyclerView.ItemDecoration {
    val decoration: Decoration
    var offsetPredicate: (item: Any) -> Boolean = { true }
    var differentDecoration: (item: Any) -> Decoration? = { null }
    var firstHasSideOffset = true
    var lastHasSideOffset = true

    constructor(itemOffset: Int) : super() {
        decoration = Decoration(itemOffset, itemOffset, itemOffset, itemOffset)
    }

    constructor(
        topOffset: Int = 0,
        bottomOffset: Int = 0,
        leftOffset: Int = 0,
        rightOffset: Int = 0
    ) : super() {
        decoration = Decoration(topOffset, bottomOffset, leftOffset, rightOffset)
    }

    constructor(
        context: Context,
        @DimenRes itemOffsetId: Int
    ) : this(context.resources.getDimensionPixelSize(itemOffsetId))

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val adapter = parent.adapter ?: return
        if (adapter.itemCount == 0) return
        val position = parent.getChildAdapterPosition(view)
        if (position < 0) return
        val item = (adapter as? BasicListAdapter)?.listItems?.getOrNull(position) ?: return
        val showOffset = offsetPredicate(item)
        val decor = differentDecoration(item) ?: decoration
        if (showOffset && decor.hasOffset()) outRect.set(
            getSideOffset(position == 0, firstHasSideOffset, decor.leftSpacing),
            decor.topSpacing,
            getSideOffset(
                position == adapter.itemCount - 1, lastHasSideOffset, decor.rightSpacing
            ),
            decor.bottomSpacing
        )
    }

    private fun getSideOffset(
        isSelectedPosition: Boolean, showOffset: Boolean, offset: Int
    ): Int = when {
        !isSelectedPosition -> offset
        else -> if (showOffset) offset else 0
    }
}