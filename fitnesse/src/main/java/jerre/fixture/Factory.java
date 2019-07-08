package jerre.fixture;

public class Factory {

    public ControlledNextDiceValue createControlledDicedValue() {
        return new ControlledNextDiceValue();
    }

    public DiceGame createDiceGame(ControlledNextDiceValue controlledNextDiceValue) {
        return new DiceGame(controlledNextDiceValue);
    }

    public DiceGame createDiceGame() {
        return new DiceGame(new ControlledNextDiceValue());
    }
}
