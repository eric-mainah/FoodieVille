package com.example.foodieville2;

public class Item {

    String name, time, company, environment;
    String food, drink;

    public Item(String name, String time, String company, String environment) {
        this.name = name;
        this.time = time;
        this.company = company;
        this.environment = environment;
    }
    public Item(String food, String drink) {
        this.food = food;
        this.drink = drink;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
