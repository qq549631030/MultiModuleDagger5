package cn.hx.multimoduledagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.hx.multimoduledagger.databinding.ActivityMainBinding
import cn.hx.news.NewsActivity
import cn.hx.user.UserActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUser.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
        binding.btnNews.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }
    }
}