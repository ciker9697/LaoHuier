package com.ciker.laohuier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ciker.laohuier.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    List<com.ciker.laohuier.Chat> data =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initChat();
        final EditText editText = findViewById(R.id.input_text);
        Button button =findViewById(R.id.send_button);

        final com.ciker.laohuier.ChatAdapter adapter = new com.ciker.laohuier.ChatAdapter(data);
        final RecyclerView recyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(ChatActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText() !=null){
                    data.add(new com.ciker.laohuier.Chat(editText.getText().toString(), com.ciker.laohuier.Chat.TYPE_SEND));
                    adapter.notifyItemInserted(data.size()-1);
                    recyclerView .scrollToPosition(data.size()-1);
                    editText.setText("");

                }else {
                    Toast.makeText(ChatActivity.this,"you cannot seng a blank text",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void initChat(){
        data.add(new com.ciker.laohuier.Chat("你好！", com.ciker.laohuier.Chat.TYPE_RECEIVED));
        data.add(new com.ciker.laohuier.Chat("你好！", com.ciker.laohuier.Chat.TYPE_SEND));
        data.add(new com.ciker.laohuier.Chat("初次见面，请多多关照！", com.ciker.laohuier.Chat.TYPE_RECEIVED));
    }
}
