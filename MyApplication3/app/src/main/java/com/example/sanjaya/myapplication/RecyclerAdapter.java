package com.example.sanjaya.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanjaya on 4/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemHolder> {
    ArrayList<ItemModel> itemModelArrayList=new ArrayList<>();
    Context context;
    public RecyclerAdapter(ArrayList<ItemModel> itemModelArrayList,Context context) {
        this.itemModelArrayList=itemModelArrayList;
        this.context=context;
    }
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new ItemHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        ItemModel itemModel = this.itemModelArrayList.get(position);
        holder.bindHolder(itemModel);
    }
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        public ItemHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.layoutItemTV);
            itemView.setOnClickListener(this);
        }

        public void bindHolder(ItemModel itemModel){
            this.textView.setText(itemModel.getItem());
        }

        @Override
        public void onClick(View v) {
            ((MainActivity)context).passingItem(textView.getText().toString());
        }
    }
}
