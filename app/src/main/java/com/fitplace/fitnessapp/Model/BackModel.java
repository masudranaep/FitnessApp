package com.fitplace.fitnessapp.Model;

public class BackModel {

    String name;
    String num;
    String set;
    int img;

    public BackModel(String name, String num, String set, int img) {
        this.name = name;
        this.num = num;
        this.set = set;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
