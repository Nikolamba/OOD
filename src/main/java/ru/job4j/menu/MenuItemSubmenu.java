package ru.job4j.menu;

import java.util.List;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface MenuItemSubmenu extends MenuItem {
    List<MenuItem> getChilds();
    void addChild(MenuItem item);
    boolean executeItem(int key);
    String showMenu();

    @Override
    default boolean isSubmenu() {
        return true;
    }
}
