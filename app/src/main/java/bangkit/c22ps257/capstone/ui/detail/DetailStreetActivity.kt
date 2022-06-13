package bangkit.c22ps257.capstone.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.c22ps257.capstone.databinding.ActivityDetailStreetBinding
import bangkit.c22ps257.capstone.model.StreetModel

class DetailStreetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailStreetBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStreetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val street = intent.getParcelableExtra<StreetModel>(EXTRA_STREET) as StreetModel
        
        binding.apply {
            val car = street.carNumber
            val truck = street.truckNumber
            val motorcycle = street.motorcycleNumber

            val vehicleNumber = car + truck + motorcycle

            tvStreetNameDetail.text = street.name
            tvStatusDetail.text = street.status
            tvVehicleNumberDetail.text = vehicleNumber.toString()
            tvCarNumber.text = car.toString()
            tvTruckNumber.text = truck.toString()
            tvMotorcycleNumber.text = motorcycle.toString()
        }
    }
    
    companion object {
        const val EXTRA_STREET = "extra_street"
    }
}
