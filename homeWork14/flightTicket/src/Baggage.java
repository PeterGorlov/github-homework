public class Baggage {
    private int amount;
    private int customFee;

    public Baggage(int amount, int customFree) {
        this.amount = amount;
        this.customFee = customFree;
    }

    public int getFee() {
        return customFee * amount;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "amount=" + amount +
                ", customFree=" + customFee +
                '}';
    }
}
