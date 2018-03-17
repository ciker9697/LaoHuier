package com.ciker.laohuier;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3 0003.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Chat> mChatList ;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
            leftMsg = itemView.findViewById(R.id.left_msg);
            rightMsg = itemView.findViewById(R.id.right_msg);

        }
    }

    public ChatAdapter(List<Chat> list){
        mChatList = list;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mes_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        Chat chat = mChatList.get(position);
        switch (chat.getType()){
            case Chat.TYPE_RECEIVED:
                holder.leftLayout.setVisibility(View.VISIBLE);
                holder.leftMsg.setText(chat.getMessage());
                holder.rightLayout.setVisibility(View.GONE);
                break;
            case Chat.TYPE_SEND:
                holder.rightLayout.setVisibility(View.VISIBLE);
                holder.rightMsg.setText(chat.getMessage());
                holder.leftLayout.setVisibility(View.GONE);
                break;
                default:
        }
    }

    @Override
    public int getItemCount() {
        return mChatList.size();
    }
}
