package bangkit.c22ps257.capstone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import bangkit.c22ps257.capstone.adapter.ListStreetAdapter
import bangkit.c22ps257.capstone.databinding.ActivityMainBinding
import bangkit.c22ps257.capstone.model.StreetModel
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var adapter: ListStreetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        database = Firebase.database

        val streetRef = database.reference.child(STREETS_CHILD)

        val manager = LinearLayoutManager(this)
        manager.stackFromEnd = false
        binding.rvStreets.layoutManager = manager

        val options = FirebaseRecyclerOptions.Builder<StreetModel>()
            .setQuery(streetRef, StreetModel::class.java)
            .build()
        adapter = ListStreetAdapter(options)
        binding.rvStreets.adapter = adapter
    }
    
    public override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    override fun onPause() {
        adapter.stopListening()
        super.onPause()
    }

    companion object {
        const val STREETS_CHILD = "streets"
    }
}
