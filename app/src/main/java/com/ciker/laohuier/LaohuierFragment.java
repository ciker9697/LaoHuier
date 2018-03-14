package com.ciker.laohuier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class LaohuierFragment extends Fragment {
    private List<Chatman> chatmanList = new ArrayList<>();
    public LaohuierFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_list_page, container, false);
        initChatman();
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(manager);
        MyAdapter myAdapter = new MyAdapter(chatmanList);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
    private void initChatman() {
        Chatman man1 = new Chatman(R.drawable.monkey,"李白","你好，我叫李白");
        for(int i=0 ; i<15 ; i++ ){
            chatmanList.add(man1);
        }
    }
}
