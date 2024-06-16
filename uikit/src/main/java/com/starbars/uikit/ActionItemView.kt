package com.starbars.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes

class ActionItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    private lateinit var titleTv: TextView
    private lateinit var endTv: TextView
    private lateinit var iconIv: ImageView

    init {
        initViews()
        applyAttributes(context, attrs, defStyleAttr, defStyleRes)
    }

    private fun initViews() {
        LayoutInflater.from(context).inflate(R.layout.action_item_view_layout, this, true)
        titleTv = findViewById(R.id.tv_action_title)
        iconIv = findViewById(R.id.iv_action_view_icon)
        endTv = findViewById(R.id.tv_end_text)
    }

    private fun applyAttributes(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ActionItemView,
            defStyleAttr,
            defStyleRes
        ).apply {
            try {
                iconIv.setImageDrawable(getDrawable(R.styleable.ActionItemView_iconResource))
                titleTv.text = getString(R.styleable.ActionItemView_itemTitleText) ?: ""
                endTv.text = getString(R.styleable.ActionItemView_endText) ?: ""
            } finally {
                recycle()
            }
        }
    }

    fun setTitle(newTitle: String) {
        titleTv.text = newTitle
    }

    fun setEndText(newText: String) {
        endTv.text = newText
    }

    fun setIconDrawable(iconId: Int) {
        iconIv.setImageResource(iconId)
    }
}