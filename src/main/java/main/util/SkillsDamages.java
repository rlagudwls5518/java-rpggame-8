package main.util;

public enum SkillsDamages {
    PERCENT_100(1.0),
    PERCENT_120(1.2),
    PERCENT_130(1.3),
    PERCENT_150(1.5),
    PERCENT_200(2.0),
    PERCENT_250(2.5),
    PERCENT_300(3.0),
    ;

    private final double rate;

    SkillsDamages(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
