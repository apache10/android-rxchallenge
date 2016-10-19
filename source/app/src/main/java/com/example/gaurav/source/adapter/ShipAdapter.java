package com.example.gaurav.source.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.source.R;
import com.example.gaurav.source.model.ShipInfo;

import java.util.List;

/**
 * Created by gaurav on 20/10/16.
 */

public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.MyViewHolder> {

    private List<ShipInfo> ShipList;

    public ShipAdapter(List<ShipInfo> shipList) {
        ShipList = shipList;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.ship_list_name,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShipInfo shipInfo= ShipList.get(position);
        holder.pname.setText("Name:"+shipInfo.getName());
        holder.cost.setText("cost:"+shipInfo.getCost());
        holder.film.setText("Films:"+shipInfo.getFilms().get(0));
    }

    @Override
    public int getItemCount() {
        return ShipList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView pname,cost,film;

        public MyViewHolder(View view){
            super(view);
            pname=(TextView)view.findViewById(R.id.name);
            cost=(TextView)view.findViewById(R.id.cost);
            film=(TextView)view.findViewById(R.id.film);
        }

    }
}