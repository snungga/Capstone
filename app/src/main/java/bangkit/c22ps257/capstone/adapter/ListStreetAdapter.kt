package bangkit.c22ps257.capstone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bangkit.c22ps257.capstone.databinding.StreetListItemBinding
import bangkit.c22ps257.capstone.model.StreetModel

class ListStreetAdapter(private val listStreet: List<StreetModel>) : RecyclerView.Adapter<ListStreetAdapter.ViewHolder>() {
    class ViewHolder(private var binding: StreetListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(street: StreetModel) {
            binding.apply {
                tvStreetName.text = street.name
                tvStatus.text = street.status
                tvVehicleNumber.text = street.vehiclePerDay.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StreetListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStreet[position])
    }

    override fun getItemCount(): Int = listStreet.size
}