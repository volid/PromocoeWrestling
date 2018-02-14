package com.example.valterpereira.promocoewrestling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.valterpereira.promocoewrestling.model.Promocao;

import java.util.List;

/**
 * Created by Valter Pereira on 14/02/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private List<Promocao> promocoes;
    private Context context;

    CustomAdapter(Context context, List<Promocao> promocoes) {
        this.context = context;
        this.promocoes = promocoes;
    }
    @Override
    public int getCount() {
        return this.promocoes.size();
    }

    @Override
    public Promocao getItem(int position) {
        return this.promocoes.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.row_list, parent,
                    false);
        }
        Promocao promocao = this.getItem(position);
        TextView name = convertView.findViewById(R.id.Titleid);
        ImageView image = convertView.findViewById(R.id.imageid);

        Glide.with(context).load(promocao.getImage()).into(image);
        name.setText(promocao.getName());

        return convertView;
    }

    void updatePromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
        notifyDataSetChanged();
    }
}
