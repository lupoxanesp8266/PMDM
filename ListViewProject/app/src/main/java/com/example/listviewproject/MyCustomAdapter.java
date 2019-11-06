package com.example.listviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {

    ArrayList<Filas> arrayList;
    Context context;

    public MyCustomAdapter(Context context, String[] titulo, String[] subtitulo, int[] imagenes) {
        //Crear ArrayList de Filas
        this.context = context;
        arrayList = new ArrayList<>();

        for (int i = 0; i < imagenes.length; i++){
            arrayList.add(new Filas(imagenes[i],titulo[i],subtitulo[i]));
        }
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View list = layoutInflater.inflate(R.layout.mylayout,parent,false);

        TextView tituloLayout = list.findViewById(R.id.titulo);
        tituloLayout.setText(arrayList.get(position).titulo);

        TextView subtituloLayout = list.findViewById(R.id.subTitulo);
        subtituloLayout.setText(arrayList.get(position).subtitulo);

        ImageView imageView = list.findViewById(R.id.imagenFIla);
        imageView.setImageResource(arrayList.get(position).imagen);



        return list;
    }
}
