package ru.job4j.foodstore;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.foodstore.stores2.WarehouseExt;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ControlQualityTest {

    private ControlQuality control;
    private final Calendar calendar = new GregorianCalendar();

    @Before
    public void setUp() {
        calendar.set(2019, Calendar.FEBRUARY, 8);
        control = new ControlQualityExt(calendar);
    }

    @Test
    public void test1() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.MARCH, 15).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        control.execute(food);
        assertEquals(1, control.getStore("Warehouse").getHeap().size());
        assertTrue(control.getStore("Shop").getHeap().isEmpty());
        assertTrue(control.getStore("Trash").getHeap().isEmpty());
    }

    @Test
    public void test2() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 25).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        control.execute(food);
        assertEquals(1, control.getStore("Shop").getHeap().size());
        assertEquals(0, control.getStore("Shop").getHeap().get(0).getDiscount());
        assertTrue(control.getStore("Warehouse").getHeap().isEmpty());
        assertTrue(control.getStore("Trash").getHeap().isEmpty());
    }

    @Test
    public void test3() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 10).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        control.execute(food);
        assertEquals(1, control.getStore("Shop").getHeap().size());
        assertEquals(20, control.getStore("Shop").getHeap().get(0).getDiscount());
        assertTrue(control.getStore("Warehouse").getHeap().isEmpty());
        assertTrue(control.getStore("Trash").getHeap().isEmpty());
    }

    @Test
    public void test4() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.MARCH, 15).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        for (int i = 0; i < 5; i++) {
            control.execute(food);
        }
        assertEquals(3, control.getStore("Warehouse").getHeap().size());
        assertEquals(2, control.getStore("Warehouse_2").getHeap().size());
    }

    @Test
    public void test5() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 7).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        food.setCanReproduct(true);
        control.execute(food);
        assertEquals(1, control.getStore("Reproduct").getHeap().size());
    }

    @Test
    public void test6() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.MARCH, 15).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        food.setVegetable(true);
        control.execute(food);
        WarehouseExt warehouse = (WarehouseExt) control.getStore("Warehouse");
        assertEquals(1, warehouse.getLowTempStorage().size());
    }
}