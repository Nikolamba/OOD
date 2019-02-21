package ru.job4j.foodstore;

import org.junit.Before;
import org.junit.Test;

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
        control = new ControlQuality(calendar);
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
}