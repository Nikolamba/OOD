package ru.job4j.menu;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface Menu {
    String toString();
    MenuItemSubmenu getRoot();
    boolean executeItem(int key);
}
