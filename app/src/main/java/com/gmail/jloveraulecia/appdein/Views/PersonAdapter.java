package com.gmail.jloveraulecia.appdein.Views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.R;

import java.util.ArrayList;

/**
 * Clase para almacenar el adaptador con los datos
 * de los acontecimientos que va a mostrar
 * el RecyclerView
 *
 * Hay que añadir al proyecto la siguiente
 * dependencia en el archivo /app/build.gradle
 * con la versión que estemos trabajando
 * 'com.android.support:recyclerview-v7:27.1.1'
 */


public class PersonAdapter
        extends RecyclerView.Adapter<PersonAdapter.AcontecimientoViewHolder>
        implements View.OnClickListener {

    private ArrayList<Person> items;
    private View.OnClickListener listener;

    // Clase interna:
    // Se implementa el ViewHolder que se encargará
    // de almacenar la vista del elemento y sus datos
    static class AcontecimientoViewHolder
            extends RecyclerView.ViewHolder {

        private TextView TextView_email;
        private TextView TextView_nombre;

        AcontecimientoViewHolder(View itemView) {
            super(itemView);
            TextView_nombre = (TextView) itemView.findViewById(R.id.TextView_Nombre);
            TextView_email = (TextView) itemView.findViewById(R.id.TextView_Email);
        }

        void AcontecimientoBind(Person item) {
            TextView_nombre.setText(item.getUser());
            TextView_email.setText(item.getEmail());
        }
    }

    // Contruye el objeto adaptador recibiendo la lista de datos
    public PersonAdapter(@NonNull ArrayList<Person> items) {
        this.items = items;
    }

    // Se encarga de crear los nuevos objetos ViewHolder necesarios
    // para los elementos de la colección.
    // Infla la vista del layout, crea y devuelve el objeto ViewHolder
    @Override
    public AcontecimientoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_data, parent, false);
        row.setOnClickListener(this);

        AcontecimientoViewHolder avh = new AcontecimientoViewHolder(row);
        return avh;
    }

    // Se encarga de actualizar los datos de un ViewHolder ya existente.
    @Override
    public void onBindViewHolder(AcontecimientoViewHolder viewHolder, int position) {
        Person item = items.get(position);
        viewHolder.AcontecimientoBind(item);
    }

    // Indica el número de elementos de la colección de datos.
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Asigna un listener al elemento
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}