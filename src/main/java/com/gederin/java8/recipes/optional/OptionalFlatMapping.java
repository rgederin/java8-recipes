package com.gederin.java8.recipes.optional;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OptionalFlatMapping {
    public static void main(String[] args) {
        Manager mrSlate = new Manager("Mr. Slate");

        Department d = new Department();
        d.setBoss(mrSlate);

        System.out.println("Boss: " + d.getBoss());

        Department d1 = new Department();
        System.out.println("Boss: " + d1.getBoss());

        /**
         * Extract a name from an Optional manager
         */

        //Extract boss from Optional before calling getName
        System.out.println("Name: " + d.getBoss().orElse(new Manager("Unknown")).getName());
        System.out.println("Name: " + d1.getBoss().orElse(new Manager("Unknown")).getName());

        //Use Optional.map to apply getName to contained Manager
        System.out.println("Name: " + d.getBoss().map(Manager::getName));
        System.out.println("Name: " + d1.getBoss().map(Manager::getName));

        /**
         * An Optional wrapped inside an Optional
         */
        Company co = new Company();
        co.setDepartment(d);

        System.out.println("Company Dept: " + co.getDepartment());
        System.out.println("Company Dept Manager: " + co.getDepartment().map(Department::getBoss));

        System.out.println(co.getDepartment()  //Optional<Department>
                .flatMap(Department::getBoss)  //Optional<Manager>
                .map(Manager::getName));       //Optional<String>
    }
}

@AllArgsConstructor
@Getter
class Manager {
    private String name;
}

@NoArgsConstructor
@Setter
class Department {
    private Manager boss;

    public Optional<Manager> getBoss() {
        return Optional.ofNullable(boss);
    }
}

@NoArgsConstructor
@Setter
class Company {
    private Department department;

    public Optional<Department> getDepartment() {
        return Optional.ofNullable(department);
    }
}