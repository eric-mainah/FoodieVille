package com.example.foodieville2;

public class Dishi {

    String ffood , drink , jina ;

    public Dishi(String ffood, String drink, String jina) {
        this.ffood = ffood;
        this.drink = drink;
        this.jina = jina;

    }

    public Dishi(){  }

    public String getJina() {
        return jina;
    }

    public void setJina(String jina) {
        this.jina = jina;
    }

    public String getFfood() {
        return ffood;
    }

    public void setFfood(String ffood) {
        this.ffood = ffood;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

}

