package ru.job4j.total;

import javafx.util.Pair;
import ru.job4j.total.field.Field;
import ru.job4j.total.field.FieldImpl;
import ru.job4j.total.figures.FigureEmpty;
import ru.job4j.total.figures.FigureO;
import ru.job4j.total.figures.FigureX;
import ru.job4j.total.input.ConsoleInput;
import ru.job4j.total.input.StubInput;
import ru.job4j.total.user.CompPlayer;
import ru.job4j.total.user.Player;
import ru.job4j.total.user.User;

/**
 * Класс, запускающий цикл игры
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class Game {
    private final Field field;
    private Chain userChain;
    private final CheckWinner checkWinner;

    public Game(Field field, int vicCondition) {
        this.field = field;
        this.checkWinner = new CheckWinner(field, vicCondition);
    }

    public void startGame(User user1, User user2) {
        userChain = new Chain(user1);
        Chain userChain2 = new Chain(user2);
        userChain.setNextChain(userChain2);
        userChain2.setNextChain(userChain);

        Chain curChain = userChain;
        do {
            userStep(curChain.getUser());
            System.out.println(this.field.toString());
            curChain = curChain.getNextChain();
        }  while (!isEndGame(curChain.getUser()));
    }

    private boolean isEndGame(User user) {
        if (checkWinner.checkWin(user.getFigure())) {
            System.out.println(user.getName() + " is winner");
            return true;
        }
        if (field.getPointByFigure(new FigureEmpty()).isEmpty()) {
            System.out.println("No winner. Game over");
            return true;
        }
        return false;
    }

    private void userStep(User user) {
        System.out.println("Move the player: " + user.getName());
        Pair<Integer, Integer> coor = user.getPair(field.getPointByFigure(new FigureEmpty()));
        field.setFigure(coor.getKey(), coor.getValue(), user.getFigure());
    }

    public static void main(String[] args) {
        System.out.println("Enter field size from 3 to 10");
        int fielsSize = new ConsoleInput().getInt(3, 10);
        Field field = new FieldImpl(fielsSize);

        System.out.println("Enter victory condition from 3 to 10");
        int vicCondition = new ConsoleInput().getInt(3, 10);
        Game game = new Game(field, vicCondition);

        System.out.println(field.toString());
        User user = new Player("player 1", new FigureX(), new ConsoleInput());
        User user1 = new CompPlayer("compPlayer", new FigureO(), new StubInput());
        game.startGame(user, user1);
    }
}
