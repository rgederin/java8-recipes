package com.gederin.java8.recipes.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Maps {
    public static void main(String[] args) {
        List<Customer> customers = init();

        customers.stream()
                .map(Customer::getName)
                .forEach(System.out::println);

        customers.stream()
                .map(Customer::getOrders)
                .forEach(System.out::println);

        customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .forEach(System.out::println);
    }

    private static List<Customer> init() {
        Customer sheridan = new Customer("Sheridan");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");

        sheridan.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));

        ivanova.addOrder(new Order(4))
                .addOrder(new Order(5));

        return Arrays.asList(sheridan, ivanova, garibaldi);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Order {
    private int id;
}


@Data
class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer addOrder(Order order) {
        orders.add(order);
        return this;
    }
}