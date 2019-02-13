package ru.job4j.menu;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface MenuItemExecutable extends MenuItem {
    int getKey();
    void execute();

    @Override
    default boolean isSubmenu() {
        return false;
    }
}
