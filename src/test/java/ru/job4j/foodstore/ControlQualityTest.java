package ru.job4j.foodstore;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.foodstore.stores.Warehouse;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ControlQualityTest {

    private ControlQualityExt control;
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
        assertEquals(1, control.getWarehouse().getHeap().size());
        assertTrue(control.getShop().getHeap().isEmpty());
        assertTrue(control.getTrash().getHeap().isEmpty());
    }

    @Test
    public void test2() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 30).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        control.execute(food);
        assertEquals(1, control.getShop().getHeap().size());
        assertEquals(0, control.getShop().getHeap().get(0).getDiscount());
        assertTrue(control.getWarehouse().getHeap().isEmpty());
        assertTrue(control.getTrash().getHeap().isEmpty());
    }

    @Test
    public void test3() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 10).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        control.execute(food);
        assertEquals(1, control.getShop().getHeap().size());
        assertEquals(20, control.getShop().getHeap().get(0).getDiscount());
        assertTrue(control.getWarehouse().getHeap().isEmpty());
        assertTrue(control.getTrash().getHeap().isEmpty());
    }

    @Test
    public void test4() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.MARCH, 15).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        for (int i = 0; i < 5; i++) {
            control.execute(food);
        }
        assertEquals(3, control.getWarehouse().getHeap().size());
        assertEquals(2, control.getWarehouse2().getHeap().size());
    }

    @Test
    public void test5() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 7).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        food.setReproductStatus(true);
        control.execute(food);
        assertEquals(1, control.getReproduct().getHeap().size());
    }

    @Test
    public void test6() {
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.MARCH, 15).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food = new Food("Milk", expireDate, createDate, 0);
        food.setVegetableSign(true);
        control.execute(food);
        Warehouse coldStorage = control.getWarehouse();
        assertEquals(1, coldStorage.getColdStorage().size());
    }
}