package com.ciker.laohuier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private List<Chatman> chatmanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChatman();
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        MyAdapter myAdapter = new MyAdapter(chatmanList);
        recyclerView.setAdapter(myAdapter);
    }

    private void initChatman() {
        Chatman man1 = new Chatman(R.drawable.monkey,"李白","你好，我叫李白");
        for(int i=0 ; i<15 ; i++ ){
            chatmanList.add(man1);
        }
    }


}
