package ru.job4j.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuItemSubmenuImpl implements MenuItemSubmenu {
    private String name;
    private List<MenuItem> childs;
    private MenuItemSubmenu parent;

    public MenuItemSubmenuImpl(String name) {
        this.name = name;
        this.childs = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addChilds(List<MenuItem> items) {
        for (MenuItem item : items) {
            item.setParent(this);
        }
        this.childs.addAll(items);
    }

    @Override
    public List<MenuItem> getChilds() {
        return this.childs;
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
        return this.name;
    }
}
