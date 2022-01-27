package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private String status;
    LocalDate orderData;
    LocalDate deliveryData;
    List<Product> products;
    Customer customer;

    public Order(Long id, String status, LocalDate orderData, LocalDate deliveryData, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderData = orderData;
        this.deliveryData = deliveryData;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderData() {
        return orderData;
    }

    public LocalDate getDeliveryData() {
        return deliveryData;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderData=" + orderData +
                ", deliveryData=" + deliveryData +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
