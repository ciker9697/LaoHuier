package com.ciker.laohuier;

import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/3 0003.
 */

public class Chat {
    public final static int TYPE_RECEIVED =0;
    public final static int TYPE_SEND = 1;
    private String message;
    private int type ;
    public String getMessage(){
        return message;
    }
    public Chat(String message,int type){
        this.message=message;
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
