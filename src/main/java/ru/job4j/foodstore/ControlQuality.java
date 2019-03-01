package ru.job4j.foodstore;

import ru.job4j.foodstore.stores.Shop;
import ru.job4j.foodstore.stores.Store;
import ru.job4j.foodstore.stores.Trash;
import ru.job4j.foodstore.stores.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ControlQuality {
    protected final Calendar calendar;
    protected final Map<String, Store> stores;

    public ControlQuality() {
        this.calendar = new GregorianCalendar();
        stores = new HashMap<>();
        stores.put("Warehouse", new Warehouse());
        stores.put("Shop", new Shop());
        stores.put("Trash", new Trash());
    }

    public ControlQuality(Calendar calendar) {
        this();
        for (Store store : stores.values()) {
            store.setCalendar(calendar);
        }
    }

    public void execute(Food food) {
        for (Store store : stores.values()) {
            if (store.process(food)) {
                break;
            }
        }
    }

    public Store getStore(String name) {
        return this.stores.get(name);
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
