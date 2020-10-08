package dev.bifel.testtask.pages.person

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.util.Linkify
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.bifel.testtask.R
import dev.bifel.testtask.global.utils.convertTimestampToDateString
import dev.bifel.testtask.model.entity.User
import kotlinx.android.synthetic.main.activity_person.*


class PersonActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        intent.getParcelableExtra<User>(USER_EXTRA)?.let(::initUser)
    }

    private fun initUser(user: User) {
        Glide.with(this)
            .load(user.picture?.large)
            .placeholder(
                CircularProgressDrawable(this)
                    .apply {
                        strokeWidth = 5f
                        centerRadius = 30f
                        setColorSchemeColors(getColor(R.color.colorAccent))
                        start()
                    })
            .apply(RequestOptions().circleCrop())
            .into(img_user_icon)

        val name = user.name
        val fullName = "${name?.first} ${name?.last}"
        text_name.text = fullName

        text_age.text = getString(R.string.age, user.dob?.age)

        text_gender.setTitle(R.string.gender)
        text_gender.setText(user.gender)

        text_email.setTitle(R.string.email)
        text_email.setText(user.email)
        Linkify.addLinks(text_email.textView, Linkify.EMAIL_ADDRESSES)

        text_dob.setTitle(R.string.dob)
        text_dob.setText(convertTimestampToDateString(user.dob?.date))

        text_phone.setTitle(R.string.phone)
        text_phone.setText(user.cell)
        Linkify.addLinks(
            text_phone.textView,
            Linkify.PHONE_NUMBERS
        ) // it's basically working, but not for all data
    }

    companion object {
        private const val USER_EXTRA = "USER_EXTRA"
        fun launch(context: Context, user: User) {
            val intent = Intent(context, PersonActivity::class.java)
            intent.putExtra(USER_EXTRA, user)
            context.startActivity(intent)
        }
    }
}