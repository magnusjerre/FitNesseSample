package jerre;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HighestDiceGame {
    private NextRandomDiceValue randomDiceValueGenerator;
    private boolean gameStarted;
    private Map<String, Integer> scores;


    public HighestDiceGame(NextRandomDiceValue nextRandomDiceValue) {
        scores = new HashMap<>();
        randomDiceValueGenerator = nextRandomDiceValue;
    }

    public Map<String, Integer> getScores() {
        Map<String, Integer> clone = new HashMap<>();
        scores.forEach((key, value) -> clone.put(key, value));
        return clone;
    }

    public boolean addUsername(String username) {
        if (gameStarted) {
            throw new IllegalStateException("Game already started");
        }
        if (scores.containsKey(username)) return false;

        scores.put(username, null);
        return true;
    }

    public boolean startGame() {
        if (gameStarted) return false;
        gameStarted = true;
        return true;
    }

    public int takeTurn(String username) {
        if (!scores.containsKey(username)) {
            throw new IllegalArgumentException("Username " + username + " not found");
        }
        Integer diceValue = scores.get(username);
        if (diceValue != null) {
            throw new IllegalStateException(username + " has already thrown the dice, received " + diceValue);
        }

        diceValue = randomDiceValueGenerator.next().getValue();
        scores.put(username, diceValue);
        return diceValue;
    }

    public String getWinner() {
        if (scores.entrySet().stream().anyMatch(entry -> entry.getValue() == null)) {
            throw new IllegalStateException("The game is not over yet, therefore we have no winner");
        }
        return scores.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

}
