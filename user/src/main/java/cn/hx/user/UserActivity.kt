package cn.hx.user

import android.os.Bundle
import androidx.activity.viewModels
import cn.hx.base.BaseActivity
import cn.hx.user.databinding.ActivityUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : BaseActivity() {

    private val userViewModel: UserViewModel by viewModels()

    lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.text = userViewModel.set.toString() + "\n" + userViewModel.data
    }
}