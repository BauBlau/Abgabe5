package HashAlgorithm.probing;

public class DoubleHashingProbing implements IProbing {

    // https://stackoverflow.com/questions/4412179/best-way-to-make-javas-modulus-behave-like-it-should-with-negative-numbers
    // https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers

    private int m = 0;

    public DoubleHashingProbing(int m) {
        super();
        this.m = m;
    }

    @Override
    public int probe(int key, int j) {
        return j * (1 + Math.floorMod(key, this.m));
    }

    @Override
    public String toString() {
        return "DoubleHashing [m'=" + m + "]";
    }
}
