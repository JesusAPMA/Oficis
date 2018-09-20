package com.proyectoprueba.jesus.proyectoprueba;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class HeaderAdapter_Historial extends RecyclerView.Adapter<HeaderAdapter_Historial.ViewHolder> {
    private List<Historial_formato> items;
    private Activity activity;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
   /*String correo_cliente;
String correo_prestador;
String fecha;
int costo;
String hora_inicio;
String hora_final;
int calificacion_prestador;
int tipo_pago;
*/
        public TextView correo_cliente;
        public TextView correo_prestador;
        public TextView fecha;
        public TextView precio;
        public TextView hora_inicio;
        public TextView hora_final;
        public TextView calificacion;
        public TextView tipo_pago;

        RelativeLayout parentLayout;
        private Context mContext;

        ViewHolder(View v) {
            super(v);
            correo_cliente = (TextView) v.findViewById(R.id.correo_cliente);
            correo_prestador = (TextView) v.findViewById(R.id.correo_prestador);
            fecha = (TextView) v.findViewById(R.id.fecha);
            precio = (TextView) v.findViewById(R.id.precio);
            hora_inicio = (TextView) v.findViewById(R.id.hora_inicial);
            hora_final = (TextView) v.findViewById(R.id.hora_final);
            calificacion = (TextView) v.findViewById(R.id.calificacion);
            tipo_pago = (TextView) v.findViewById(R.id.tipo_pago);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HeaderAdapter_Historial(List<Historial_formato> items,Activity activity) {

       this.items= items;
        this.activity= activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_header_historial, parent, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        viewHolder.correo_cliente.setText(items.get(i).getCorreo_cliente());
        viewHolder.correo_prestador.setText(items.get(i).getCorreo_prestador());
        viewHolder.fecha.setText(items.get(i).getFecha());
        viewHolder.precio.setText(items.get(i).getCosto()+"");
        viewHolder.hora_inicio.setText(items.get(i).getHora_inicio());
        viewHolder.hora_final.setText(items.get(i).getHora_final());
        viewHolder.calificacion.setText(items.get(i).getCalificacion_prestador()+"");
        if (items.get(i).getTipo_pago()==1) {
            viewHolder.tipo_pago.setText("Efectivo");
        }
        else{
            viewHolder.tipo_pago.setText("Tarjeta");
        }

       // viewHolder.calificacion.setText("Calificación: "+String.valueOf(items.get(i).getCalificacion()));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

}