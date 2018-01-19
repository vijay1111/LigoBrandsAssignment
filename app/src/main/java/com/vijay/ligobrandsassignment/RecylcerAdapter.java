package com.vijay.ligobrandsassignment;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Ashutosh Srivastava on 07-01-2018 14:49.
 * Project Name : RvChips
 */

public class RecylcerAdapter extends RecyclerView.Adapter<RecylcerAdapter.ItemVH> {

    private ArrayList<String> items;
    private Context context;

    private RecylcerAdapter() {
    }

    RecylcerAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    @Override
    public ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemVH(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemVH holder, final int position) {

        String item = items.get(position);
        holder.tvName.setText(item);
        holder.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public synchronized void addItem(String item) {
        if (item == null || item.isEmpty()) return;
        this.items.add(item);
        notifyItemInserted(getItemCount());
    }

    public synchronized void removeItem(int position) {
        if (items.isEmpty()) return;
        items.remove(position);
        notifyDataSetChanged();
    }

    public class ItemVH extends RecyclerView.ViewHolder {

        AppCompatTextView tvName;
        AppCompatImageView ivRemove;

        public ItemVH(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            ivRemove = itemView.findViewById(R.id.iv_remove);
        }
    }
}
