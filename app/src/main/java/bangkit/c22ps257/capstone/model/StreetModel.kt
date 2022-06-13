package bangkit.c22ps257.capstone.model

import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.parcelize.Parcelize

@Parcelize
@IgnoreExtraProperties
data class StreetModel(
    val name: String? = null,
    val carNumber: Int = 0,
    val truckNumber: Int = 0,
    val motorcycleNumber: Int = 0,
    val status: String? = null
) : Parcelable {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}
