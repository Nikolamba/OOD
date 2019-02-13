package ru.job4j.menu;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuItemExecutableImpl implements MenuItemExecutable {

    private int key;
    private String name;
    private MenuItemSubmenu parent;

    public MenuItemExecutableImpl(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public void execute() {

    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MenuItemSubmenu getParent() {
        return this.parent;
    }

    @Override
    public void setParent(MenuItemSubmenu parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return key + ". " + name;
    }
}
