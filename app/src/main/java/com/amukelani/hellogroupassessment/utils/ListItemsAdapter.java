package com.amukelani.hellogroupassessment.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raywenderlich.hellogroupassessment.R;
import com.raywenderlich.hellogroupassessment.models.ListItems;

import java.util.List;

/**
 * Created by Amukelani on 9/25/16.
 */
public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.MyViewHolder> {

    private List<ListItems> listItemses;

    public ListItemsAdapter(List<ListItems> listItemses){
        this.listItemses = listItemses;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, num;

        public MyViewHolder(View view){
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            num = (TextView) view.findViewById(R.id.num);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_rage_comic, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ListItems listItems = listItemses.get(position);
        holder.title.setText(listItems.getTitle());
//        holder.num.setText(listItems.getNum());
    }

    @Override
    public int getItemCount() {
        return listItemses.size();
    }
}
