package dev.bifel.testtask.pages.person

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue.COMPLEX_UNIT_PX
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import dev.bifel.testtask.R

/**
 * Date: 08.10.2020
 * Time: 22:31
 *
 * @author Bohdan Ishchenko
 */
class TitledTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    val titleView = TextView(context)
    val textView = TextView(context)

    init {
        orientation = VERTICAL

        titleView.setTextColor(context.getColor(R.color.text_secondary))
        titleView.setTextSize(
            COMPLEX_UNIT_PX,
            context.resources.getDimension(R.dimen.size_text_small)
        )
        textView.setTextColor(context.getColor(R.color.text_primary))
        textView.setTextSize(COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.size_text_big))

        addView(titleView)
        addView(textView)
        val divider = View(context)
        divider.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, 2)
        divider.setBackgroundColor(context.getColor(R.color.text_secondary))
        addView(divider)
    }

    fun setTitle(@StringRes value: Int) = titleView.setText(value)

    fun setText(value: String?) {
        textView.text = value
    }
}