package com.example.doctormobile.helpers

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class RecyclerDecoration(
    private val left: Int = 0,
    private val right: Int = 0,
    private val top: Int = 0,
    private val bottom: Int = 0
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.let {
            it.left = left
            it.right = right
            it.top = top
            it.bottom = bottom
        }
    }
}