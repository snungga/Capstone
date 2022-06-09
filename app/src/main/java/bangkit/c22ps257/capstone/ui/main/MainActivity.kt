package bangkit.c22ps257.capstone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.c22ps257.capstone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}