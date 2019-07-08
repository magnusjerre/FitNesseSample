package jerre.fixture;

import jerre.DiceValue;
import jerre.NextRandomDiceValue;

public class ControlledNextDiceValue implements NextRandomDiceValue {
    DiceValue nextValue;

    public void setNextValue(int value) {
        nextValue = DiceValue.fromInt(value);
    }

    @Override
    public DiceValue next() {
        return nextValue;
    }
}
