package ru.job4j.menu;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuItemExecutableImpl implements MenuItemExecutable {

    private int key;
    private String name;
    private MenuItemSubmenu parent;

    public MenuItemExecutableImpl(int key, String name, MenuItemSubmenu parent) {
        this.key = key;
        this.name = name;
        this.parent = parent;
        this.parent.addChild(this);
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
    public String toString() {
        return key + ". " + name;
    }
}
