package cn.hx.user

import android.os.Bundle
import androidx.activity.viewModels
import cn.hx.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user.*

@AndroidEntryPoint
class UserActivity : BaseActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        text.text = userViewModel.set.toString() + "\n" + userViewModel.data
    }
}