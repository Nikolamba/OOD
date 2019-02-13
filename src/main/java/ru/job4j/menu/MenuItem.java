package ru.job4j.menu;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface MenuItem {
    String getName();
    MenuItemSubmenu getParent();
    void setParent(MenuItemSubmenu parent);
    boolean isSubmenu();
}
