package jerre.fixture;

import jerre.HighestDiceGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiceGame {
    private HighestDiceGame game;
    private ControlledNextDiceValue nextDiceValue;

    public DiceGame(ControlledNextDiceValue nextDiceValue) {
        this.nextDiceValue = nextDiceValue;
        this.game = new HighestDiceGame(nextDiceValue);
    }

    public boolean addPlayer(String name) {
        return game.addUsername(name);
    }

    public boolean startGame() {
        return game.startGame();
    }

    public void takeTurnAndRoll(String username, int number) {
        nextDiceValue.setNextValue(number);
        game.takeTurn(username);
    }

    public String getWinner() {
        return game.getWinner();
    }

    /**
     * FitNesse's query table expects the query-function to exist, and that it returns a list of list of list of string.
     * The first list represents all rows, the second list represents a specific row, the third (innermost) list is a
     * two-valued key-value list. The fields described in the second row of the query table must map to the keys/fields
     * defined in the innermost lists. The query table can therefore only include the fields "username" and "score"
     * defined in this method-implementation.
     */
    public List<List<List<String>>> query() {
        return game.getScores().entrySet().stream()
                .map(entry -> Arrays.asList(
                        Arrays.asList("username", entry.getKey()),
                        Arrays.asList("score", entry.getValue() != null ? entry.getValue().toString() : "")
                )).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "Instance";
    }

}
