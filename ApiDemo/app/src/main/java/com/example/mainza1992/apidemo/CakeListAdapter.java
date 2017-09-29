package com.example.mainza1992.apidemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainza1992.apidemo.data.network.model.CakeListModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mainza1992 on 27/09/2017.
 */

class CakeListAdapter extends RecyclerView.Adapter<CakeListAdapter.CakesViewHolder> {

    private List<CakeListModel> cakeListModel;
    private int row;
    private  Context applicationContext;

    public CakeListAdapter(List<CakeListModel> cakeListModels, int row, Context applicationContext) {
        this.cakeListModel = cakeListModels;
        this.row= row;
        this.applicationContext= applicationContext;
    }

    @Override
    public CakeListAdapter.CakesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(row,null);
        return new CakesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CakeListAdapter.CakesViewHolder holder, int position) {
        holder.tvTitle.setText(cakeListModel.get(position).getTitle());
        /**
         * image loading library
         *
         */

        Picasso.with(applicationContext)
                .load(cakeListModel.get(position).getImage())
                .resize(500, 250)
                .centerCrop()
                .into(holder.imgcake);
    }

    @Override
    public int getItemCount() {
        return cakeListModel.size();
    }


    public class CakesViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView imgcake;

        public CakesViewHolder (View itemView){
            super(itemView);
            tvTitle=(TextView)itemView.findViewById(R.id.textView);
            imgcake=(ImageView)itemView.findViewById(R.id.imageView);

        }
    }
}
