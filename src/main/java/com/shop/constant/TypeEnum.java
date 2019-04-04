package com.shop.constant;

/**
 * Created by TL20160428 on 2019/04/03.
 */
public enum TypeEnum {

    //文本
    TEXT(0, "text"),
    //图片
    IMAGE(1, "image");

    private int type;

    private String name;

    TypeEnum() {
    }

     TypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
