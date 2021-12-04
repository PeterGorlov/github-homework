public class Order {
    private final String customer;
    private final String gud;
    private final Integer count;

    public Order(String customer,String gud, Integer count){
        this.customer = customer;
        this.gud = gud;
        this.count = count;
    }

    public String getCustomer() {
        return customer;
    }

    public String getGud() {
        return gud;
    }

    public Integer getCount() {
        return count;
    }
}