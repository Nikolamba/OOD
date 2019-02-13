package ru.job4j.menu;

import java.util.*;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class MenuImpl implements Menu {
    private Queue<MenuItem> queueItems;
    private Map<Integer, MenuItemExecutable> executableMenu;
    private MenuItemSubmenu root;
    private String stringMenu;

    public MenuImpl(List<MenuItem> items) {
        this.root = new MenuItemSubmenuImpl("root");
        this.root.setParent(null);
        this.root.addChilds(items);
        this.queueItems = new LinkedList<>();
        this.executableMenu = new HashMap<>();
        for (MenuItem item : items) {
            init(item);
        }
        stringMenu = buildString();
    }

    public boolean executeItem(int key) {
        if (this.executableMenu.containsKey(key)) {
            this.executableMenu.get(key).execute();
            return true;
        }
        return false;
    }

    public String toString() {
        return this.stringMenu;
    }

    @Override
    public MenuItemSubmenu getRoot() {
        return this.root;
    }

    private String buildString() {
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
        int level = -1;
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
