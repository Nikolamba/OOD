package ru.job4j.menu;

import java.util.Arrays;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuBuild {

    public static void main(String[] args) {

        MenuItemSubmenuImpl submenu = new MenuItemSubmenuImpl("menu");
        MenuItemExecutableImpl exMenu1 = new MenuItemExecutableImpl(1, "task 1");
        MenuItemExecutableImpl exMenu2 = new MenuItemExecutableImpl(2, "task 2");
        submenu.addChilds(Arrays.asList(exMenu1, exMenu2));

        MenuItemSubmenuImpl submenu2 = new MenuItemSubmenuImpl("menu");
        MenuItemExecutableImpl exMenu3 = new MenuItemExecutableImpl(3, "task 3");
        MenuItemExecutableImpl exMenu4 = new MenuItemExecutableImpl(4, "task 4");
        submenu2.addChilds(Arrays.asList(exMenu3, exMenu4));

        MenuItemSubmenuImpl submenu1 = new MenuItemSubmenuImpl("menu");
        submenu1.addChilds(Arrays.asList(submenu2));

        MenuImpl menu = new MenuImpl(Arrays.asList(submenu, submenu1));
        System.out.println(menu.toString());
    }
}
