package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.stores.Trash;

public class TrashChainExt extends TrashChain {

    public TrashChainExt(Trash trash) {
        super(trash);
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) >= 100 && !food.canReproduct()) {
            this.trash.add(food);
        } else {
            this.next.process(food);
        }
    }
}
