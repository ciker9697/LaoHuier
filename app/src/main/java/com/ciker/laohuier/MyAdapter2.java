package com.ciker.laohuier;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {
    private List<Chatman> chatManList;
    public MyAdapter2(List<Chatman> chatManList){
        this.chatManList = chatManList;
    }
    @Override
    public MyAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter2.ViewHolder holder, int position) {
        Chatman chatman = chatManList.get(position);
        holder.imageView.setImageResource(chatman.getImageId());
        holder.name.setText(chatman.getName());
        holder.content.setText(chatman.getContent());
    }

    @Override
    public int getItemCount() {
        return chatManList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.chat_head);
            name = itemView.findViewById(R.id.chat_name);
            content = itemView.findViewById(R.id.chat_content);
        }
    }
}

