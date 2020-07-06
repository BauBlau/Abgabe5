package HashAlgorithm.hash;

public class Hash implements IHash {

    // https://stackoverflow.com/questions/4412179/best-way-to-make-javas-modulus-behave-like-it-should-with-negative-numbers
    // https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers

    private int m;

    public Hash(int m) {
        super();
        this.m = m;
    }

    @Override
    public int hash(int key) {
        return Math.floorMod(key, m);
    }

    @Override
    public String toString() {
        return "Hash";
    }

}
