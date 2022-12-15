package com.example.finalproject4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class DaftarBussAdapter extends RecyclerView.Adapter<DaftarBussAdapter.ViewHolder> {

private Context context;
private List<DaftarBussModel> bussList;

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View theView = LayoutInflater.from(parent.getContext()).inflate(R.layout.buss_layout, parent, false);
        return new ViewHolder(theView);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    DaftarBussModel club = bussList.get(position);
        holder.tvbussName.setText(club.getName());
        Picasso.get().load(club.getLogo()).fit().centerCrop().into(holder.imgbussLogo);
        }

@Override
public int getItemCount() {
        return bussList.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {

    public TextView tvbussName;
    public ImageView imgbussLogo;

    public ViewHolder(View itemView){
        super(itemView);
        tvbussName = itemView.findViewById(R.id.buss_name);
        imgbussLogo = itemView.findViewById(R.id.buss_logo);
    }
}

    public DaftarBussAdapter(Context context, List<DaftarBussModel> clubList){
        this.context = context;
        this.bussList = clubList;
    }

}
