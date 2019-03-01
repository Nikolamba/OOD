package ru.job4j.menu;

import java.util.Arrays;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuBuild {

    public static void main(String[] args) {

        MenuItemSubmenu menu = new MenuItemSubmenuImpl("root menu", null);

        MenuItemSubmenuImpl submenu1 = new MenuItemSubmenuImpl("menu 1", menu);
        new MenuItemExecutableImpl(1, "task 1", submenu1);
        new MenuItemExecutableImpl(2, "task 2", submenu1);

        MenuItemSubmenuImpl submenu = new MenuItemSubmenuImpl("menu 2", menu);
        new MenuItemExecutableImpl(3, "task 3", submenu);
        new MenuItemExecutableImpl(4, "task 4", submenu);
        MenuItemSubmenuImpl submenu2 = new MenuItemSubmenuImpl("menu 3", submenu);
        new MenuItemExecutableImpl(5, "task 5", submenu2);

        //System.out.println(menu.toString());
        System.out.println(menu.showMenu());

    }
}
