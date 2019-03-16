package ru.job4j.foodstore;

import ru.job4j.foodstore.stores.Store;
import ru.job4j.foodstore.stores2.Reproduct;
import ru.job4j.foodstore.stores2.TrashExt;
import ru.job4j.foodstore.stores2.WarehouseExt;

import java.util.Calendar;

/**
 * Расширенный класс для распределения продуктов
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class ControlQualityExt extends ControlQuality {

    public ControlQualityExt() {
        super();
        stores.replace("Warehouse", new WarehouseExt(3, 1));
        stores.replace("Trash", new TrashExt());
        stores.put("Warehouse_2", new WarehouseExt(5, 2));
        stores.put("Reproduct", new Reproduct());
    }

    public ControlQualityExt(Calendar calendar) {
        this();
        for (Store store : stores.values()) {
            store.setCalendar(calendar);
        }
    }
}
