package com.example.digitalconstruction.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.digitalconstruction.Data.Items;
import com.example.digitalconstruction.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Items> mList;
    private OnItemClickListener mListener;

    public ItemAdapter(Context context){
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setRentItems(ArrayList<Items> rentItems){
        this.mList = rentItems;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivItem;
        public TextView tvNama, tvHarga, tvJam, tvLokasi, tvUnit;

        public CategoryViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
//            tvUnit = itemView.findViewById(R.id.detail_items_unit);
            ivItem = itemView.findViewById(R.id.items_image);
            tvHarga = itemView.findViewById(R.id.item_harga);
            tvJam = itemView.findViewById(R.id.item_jam);
            tvNama = itemView.findViewById(R.id.item_nama);
            tvLokasi = itemView.findViewById(R.id.item_kota);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int i = getAdapterPosition();
                        if (i != RecyclerView.NO_POSITION){
                            listener.onItemClick(i);
                        }
                    }
                }
            });

        }
    }

    public ItemAdapter(ArrayList<Items>exampleList){
        mList = exampleList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rent,parent,false);
        return new CategoryViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Items currentItems = mList.get(position);

        Glide.with(holder.ivItem).load(currentItems.getImg()).into(holder.ivItem);
        holder.tvNama.setText(currentItems.getNama());
        holder.tvJam.setText(currentItems.getJam());
        holder.tvHarga.setText(currentItems.getHarga());
        holder.tvLokasi.setText(currentItems.getKota());
//        holder.tvUnit.setText(currentItems.getUnit());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
