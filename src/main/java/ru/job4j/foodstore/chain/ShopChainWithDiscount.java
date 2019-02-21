package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.Shop;

public class ShopChainWithDiscount extends ShopChain {
    private int discount;

    public ShopChainWithDiscount(Shop shop, int discount) {
        super(shop);
        this.discount = discount;
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) > 75 && shelfLife(food, calendar) < 100) {
            food.setDiscount(discount);
            this.shop.add(food);
        } else {
            this.next.process(food);
        }
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
