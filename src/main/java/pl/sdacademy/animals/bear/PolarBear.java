package pl.sdacademy.animals.bear;

public class PolarBear extends Bear {
    public PolarBear(int weight) {
        super(weight);
    }

    @Override
    boolean isHibernating() {
        return false;
    }
}
