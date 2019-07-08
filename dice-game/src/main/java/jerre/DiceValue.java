package jerre;

public enum DiceValue {
    DV_1(1),
    DV_2(2),
    DV_3(3),
    DV_4(4),
    DV_5(5),
    DV_6(6);

    private int value;

    DiceValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DiceValue fromInt(int number) {
        switch (number) {
            case 1: return DV_1;
            case 2: return DV_2;
            case 3: return DV_3;
            case 4: return DV_4;
            case 5: return DV_5;
            case 6: return DV_6;
            default: {
                if (number < 1) return DV_1;
                else return DV_6;
            }
        }
    }
}
