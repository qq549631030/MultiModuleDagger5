package cn.hx.news

import android.os.Bundle
import cn.hx.base.BaseActivity
import cn.hx.news.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : BaseActivity() {

    @Inject
    lateinit var set: Set<String>

    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.text = set.toString()
    }
}