package ru.job4j.menu;

import java.util.*;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuItemSubmenuImpl implements MenuItemSubmenu {
    private String name;
    private List<MenuItem> childs;
    private MenuItemSubmenu parent;
    private Queue<MenuItem> queueItems;
    private Map<Integer, MenuItemExecutable> executableMenu;

    public MenuItemSubmenuImpl(String name, MenuItemSubmenu parent) {
        this.name = name;
        this.childs = new ArrayList<>();
        this.parent = parent;
        this.queueItems = new LinkedList<>();
        this.executableMenu = new HashMap<>();
        if (parent != null) {
            this.parent.addChild(this);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addChild(MenuItem item) {
        this.childs.add(item);
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
    public String toString() {
        return this.name;
    }

    @Override
    public boolean executeItem(int key) {
        this.init(this);
        MenuItemExecutable item = executableMenu.get(key);
        if (item != null) {
            item.execute();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String showMenu() {
        this.init(this);
        StringBuilder sb = new StringBuilder();
        while (!queueItems.isEmpty()) {
            MenuItem item = queueItems.poll();
            for (int i = 0; i < getLevel(item); i++) {
                sb.append("\t");
            }
            sb.append(item.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private int getLevel(MenuItem node) {
        int level = 0;
        while (node.getParent() != null) {
            node = node.getParent();
            level++;
        }
        return level;
    }

    private void init(MenuItem node) {
        if (!node.isSubmenu()) {
            this.queueItems.offer(node);
            this.executableMenu.put(((MenuItemExecutable) node).getKey(), (MenuItemExecutable) node);
        } else {
            this.queueItems.offer(node);
            MenuItemSubmenu submenu = (MenuItemSubmenu) node;
            for (MenuItem child : submenu.getChilds()) {
                init(child);
            }
        }
    }




}
