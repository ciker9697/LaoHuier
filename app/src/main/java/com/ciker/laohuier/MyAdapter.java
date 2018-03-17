package com.ciker.laohuier;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2018/3/8 0008.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Chatman> chatManList;//全局变量
    public MyAdapter(List<Chatman> chatManList){
        this.chatManList = chatManList;
    }//构造函数，将数据源传进来，赋值给全局变量chatManList
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.chatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"进入聊天",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),ChatActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }//将子项布局加载进来，然后创建一个ViewHolder实例，并把加载的子项布局传到构造函数中去，最后返回ViewHolder。

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Chatman chatman = chatManList.get(position);
        holder.imageView.setImageResource(chatman.getImageId());
        holder.name.setText(chatman.getName());
        holder.content.setText(chatman.getContent());
    }//对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行，这里通过position参数得到当前项的chatMan实例，然后再将数据设置到ViewHolder的各个空间中。

    @Override
    public int getItemCount() {
        return chatManList.size();
    }//返回数据源长度即可。

    static class ViewHolder extends RecyclerView.ViewHolder {
        View chatView;
        ImageView imageView;
        TextView name;
        TextView content;

        public ViewHolder(View itemView) {//RecyclerView子项最外层布局
            super(itemView);
            chatView = itemView;
            imageView = itemView.findViewById(R.id.chat_head);
            name = itemView.findViewById(R.id.chat_name);
            content = itemView.findViewById(R.id.chat_content);
        }//加载控件
    }
}
