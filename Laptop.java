public class Laptop implements Comparable<Laptop> {
    int gains;
    int price;

    public Laptop(int gains, int price) {
        this.gains = gains;
        this.price = price;
    }

    @Override
    public int compareTo(Laptop other) {
        return Integer.compare(this.gains, other.gains);
    }
}