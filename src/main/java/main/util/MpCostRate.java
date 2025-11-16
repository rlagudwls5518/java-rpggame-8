package main.util;

public enum MpCostRate {
    MPCOST_10(10),
    MPCOST_20(20),
    MPCOST_25(25),
    MPCOST_30(30),
    MPCOST_50(50),
    MPCOST_60(60);

    private final int mpCost;

    MpCostRate(int mpCost) {
        this.mpCost = mpCost;
    }

    public int getmpCost() {
        return mpCost;
    }
}
