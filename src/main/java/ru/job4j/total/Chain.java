package ru.job4j.total;

import ru.job4j.total.user.User;

public class Chain {
    private final User user;
    private Chain nextChain;

    public Chain(User user) {
        this.user = user;
    }

    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    public Chain getNextChain() {
        return this.nextChain;
    }

    public User getUser() {
        return user;
    }
}
