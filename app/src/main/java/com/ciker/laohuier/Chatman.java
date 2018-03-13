package com.ciker.laohuier;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

class Chatman {
    private int imageId;
    private String name;
    private String content;
    public void setImageId(int imageId){
        this.imageId = imageId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setContent(String content){
        this.content = content;
    }
    public int getImageId(){
        return imageId;
    }
    public String getName(){return name;};
    public String getContent(){return content;};
    public Chatman(int imageId,String name,String content){
        setImageId(imageId);
        setName(name);
        setContent(content);
    }
}
