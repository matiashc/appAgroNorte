package co.edu.ufps.norteagroapp.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.edu.ufps.norteagroapp.R
import co.edu.ufps.norteagroapp.modelo.Tienda
import com.google.android.material.button.MaterialButton

class TiendaAdapter (var context: Context?, val dataSet: ArrayList<Tienda>, recurso: Int):
    Adapter<TiendaAdapter.TiendaViewHolder>() {

    class TiendaViewHolder(view: View):ViewHolder(view){
var nombreTienda: TextView
var descripcionTienda: TextView
var imagenTienda: ImageView
var telefonoTienda: MaterialButton
var localizacionTienda: MaterialButton
init {
    nombreTienda = view.findViewById(R.id.nombre_tienda)
    descripcionTienda = view.findViewById(R.id.descripcion_tienda)
    imagenTienda = view.findViewById(R.id.imagen_tienda)
    telefonoTienda = view.findViewById(R.id.telefono_tienda)
    localizacionTienda = view.findViewById(R.id.localizacion_tienda)
}

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaViewHolder {
        val layoutinflater= LayoutInflater.from(parent.context)
        val view: View = layoutinflater.inflate(R.layout.card,parent,false)
        return TiendaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TiendaViewHolder, position: Int) {
        holder.nombreTienda.setText(dataSet[position].nombre)
        holder.descripcionTienda.setText(dataSet[position].descripcion)
        holder.telefonoTienda.setText(dataSet[position].telefono)
        holder.localizacionTienda.setText(dataSet[position].latitud + dataSet[position].longitud)
        Picasso.get().load(dataSet[position].imagen).into(holder.imagenTienda);

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}