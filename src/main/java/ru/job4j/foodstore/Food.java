package ru.job4j.foodstore;

import java.util.Date;

public class Food {
    private String name;
    private Date expareDate;
    private Date createDate;
    private double price;
    private int discount;

    public Food(String name, Date expareDate, Date createDate, double price) {
        this.name = name;
        this.expareDate = expareDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Date getExpareDate() {
        return expareDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpareDate(Date expareDate) {
        this.expareDate = expareDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", price=" + price
                + '}';
    }
}
