package com.gederin.java8.recipes.collectors;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MaxMin {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Cersei", 250_000, "Lannister"),
                new Employee("Jamie", 150_000, "Lannister"),
                new Employee("Tyrion", 1_000, "Lannister"),
                new Employee("Tywin", 1_000_000, "Lannister"),
                new Employee("Jon Snow", 75_000, "Stark"),
                new Employee("Robb", 120_000, "Stark"),
                new Employee("Eddard", 125_000, "Stark"),
                new Employee("Sansa", 0, "Stark"),
                new Employee("Arya", 1_000, "Stark"));

        Employee defaultEmployee = new Employee("A man (or woman) has no name", 0, "Black and White");

        /**
         * Given a collection of employees, you can use the reduce method on Stream,
         * which takes a BinaryOperator as an argument.
         *
         * Using BinaryOperator.maxBy
         */
        Optional<Employee> optionalEmp = employees.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary)));

        System.out.println("Emp with max salary: " +
                optionalEmp.orElse(defaultEmployee));

        /**
         * Using Stream.max
         */
        optionalEmp = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary));


        /**
         * Using Collectors.maxBy
         */
        optionalEmp = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));

        /**
         * Note that there is also a method called max on the primitive
         * streams (IntStream, Long Stream, and DoubleStream) that takes no arguments.
         */

        OptionalInt maxSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .max();

        System.out.println("The max salary is " + maxSalary);

        /**
         * Using Collectors.maxBy as a downstream collector
         */
        Map<String, Optional<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(
                                Comparator.comparingInt(Employee::getSalary))));

        map.forEach((house, emp) ->
                System.out.println(house + ": " + emp.orElse(defaultEmployee)));

    }
}

@Data
@AllArgsConstructor
class Employee {
    private String name;
    private Integer salary;
    private String department;
}