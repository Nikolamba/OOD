package ru.job4j.foodstore;

import java.util.Date;

public class Food implements FoodInterface {
    protected String name;
    protected Date expareDate;
    protected Date createDate;
    protected double price;
    protected int discount;
    protected boolean canReproduct;
    protected boolean isVegetable;

    public Food(String name, Date expareDate, Date createDate, double price) {
        this.name = name;
        this.expareDate = expareDate;
        this.createDate = createDate;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getExpareDate() {
        return expareDate;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean canReproduct() {
        return this.canReproduct;
    }

    @Override
    public void setReproductStatus(boolean status) {
        this.canReproduct = status;
    }

    @Override
    public boolean isVegetable() {
        return this.isVegetable;
    }

    @Override
    public void setVegetableSign(boolean sign) {
        this.isVegetable = sign;
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
