package com.fitplace.fitnessapp.Model;

public class ChestModel {
    String name;
    String set;
    String num;
    int ing;

    public ChestModel(String name, String set, String num, int ing) {
        this.name = name;
        this.set = set;
        this.num = num;
        this.ing = ing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getIng() {
        return ing;
    }

    public void setIng(int ing) {
        this.ing = ing;
    }


}
