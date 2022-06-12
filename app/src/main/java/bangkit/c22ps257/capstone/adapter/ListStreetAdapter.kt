package bangkit.c22ps257.capstone.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bangkit.c22ps257.capstone.databinding.StreetListItemBinding
import bangkit.c22ps257.capstone.model.StreetModel
import bangkit.c22ps257.capstone.ui.detail.DetailStreetActivity
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ListStreetAdapter(options: FirebaseRecyclerOptions<StreetModel>)
    : FirebaseRecyclerAdapter<StreetModel, ListStreetAdapter.ViewHolder>(options) {
        
    inner class ViewHolder(private var binding: StreetListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(street: StreetModel) {
            binding.apply {
                tvStreetName.text = street.name
                tvStatus.text = street.status
                val car = street.carNumber
                val truck = street.truckNumber
                val motor = street.motorcycleNumber
                val vehicleNumber = car + truck + motor
                tvVehicleNumber.text = vehicleNumber.toString()
            }
            
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailStreetActivity::class.java)
                intent.putExtra(DetailStreetActivity.EXTRA_STREET, street)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StreetListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: StreetModel) {
        holder.bind(model)
    }
}
