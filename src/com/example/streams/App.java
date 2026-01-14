package com.example.streams;


import main.java.com.example.streams.model.*;
import main.java.com.example.streams.service.CustomerService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        List<Customer> customers = List.of(
                new Customer(1L, "Ali", 28, true, List.of("Internet", "Mobile"), Gender.MALE),
                new Customer(6L, "Veli", 20, false, List.of("Internet", "Mobile"), Gender.MALE),
                new Customer(2L, "Ayşe", 35, true, List.of("Internet"), Gender.FEMALE),
                new Customer(3L, "Mehmet", 42, false, List.of("TV", "Mobile"), Gender.MALE),
                new Customer(4L, "Zeynep", 31, false, List.of("TV", "Internet"), Gender.FEMALE),
                new Customer(5L, "Abdi", 33, false, List.of("TV", "Internet", "Mobile"), Gender.FEMALE)
        );

        CustomerService service = new CustomerService(customers);

        System.out.println("Active customers: " + service.getActiveCustomers());
        System.out.println("Names older than 30: " + service.getCustomerNamesOlderThan30());
        System.out.println("List of services: " + service.getAllServices());
        System.out.println("List of unique services: " + service.getAllUniqueServices());
        System.out.println("Oldest customer: " + service.getOldestCustomer().orElse(null));
        System.out.println("Youngest customer: " + service.getYoungestCustomerName());
        System.out.println("Any active customer? " + service.hasAnyActiveCustomer());
        System.out.println("Count of active customers: " + service.activeCustomersCount());
        System.out.println("Count of male customers: " + service.countOfMaleCustomers());
        System.out.println("Count of active male customers: " + service.countOfMaleActiveCustomers());
        System.out.println("Active male customer names: " + service.getActiveMaleCustomerNames());
        System.out.println("Age avg of all customers: " + service.avgAgeOfAllCustomers());
        System.out.println("Active male customers age average: " + service.averageAgeOfActiveMaleCustomers());
        System.out.println("Inactive customers age average: " + service.averageAgeOfInactiveCustomers());
        System.out.println("List of female customers: " + service.getFemaleCustomers());
        System.out.println("testCase ActiveCustomersNames: " + service.getActiveCustomersNames());
        System.out.println("testCase2 first female customer: " + service.findFirstCustomer());
        System.out.println("testCase3 X male customer: " + service.findXMaleCustomer(2));
        System.out.println("Grouping customers by gender: " + service.groupCustomersByGender());
        Map<Gender, List<Customer>> grouped = service.groupCustomersByGender();
        grouped.forEach((gender, list) -> {
            System.out.println(gender + " -> " + list.size());
        });
        System.out.println("Grouping active customers by gender: " + service.groupActiveCustomersByGender());
        System.out.println("Grouping active/passive customers by gender: " + service.countActivePassiveCustomersByGender());
        System.out.println("Grouping customers by active1: " + service.groupCustomersByActive());
        System.out.println("Grouping customers by active2: " + service.groupCustomersByActive2());
        System.out.println("Stats for customers count and age avg: " + service.getCustomerCountAndAverageAge());
        System.out.println("Stats for active/passive count and age avg: " + service.getActivePassiveStats());
        System.out.println("Name Length: " + Arrays.toString(service.getNameLength()));
        System.out.println("Count of Active Passive Count- 1.4.5_partitioning: " + service.countActivePassiveCustomersByPartitioning());
        System.out.println("Count of Active Passive Count- 1.4.5_teeing: " + service.countActivePassiveCustomersByTeeing());
        ActivePassiveCount activePassiveCount = service.countActivePassiveCustomersByTeeing();
        System.out.println("Active Passive Count- 1.4.5_teeing - Actives: " + activePassiveCount.getActive() + " Passives: " + activePassiveCount.getPassive());
        GenderCountStats genderCount = service.countByGenderByTeeing();
        System.out.println("Male Female Count- 1.4.6_teeing - Males: " + genderCount.getMale() + " Females: " + genderCount.getFemale());
        GenderActiveCountStats genderActiveCountStats = service.countActiveCustomersByGenderByTeeing();
        System.out.println("Active Male Female Count- 1.4.7_teeing - Males: " + genderActiveCountStats.getActiveMales() + " Females: " + genderActiveCountStats.getActiveFemales());
        AgeSummaryStats ageSummaryStats = service.findAgeSummaryByTeeing();
        System.out.println("Max Age and Avg Age Stats- 1.4.8_teeing - Max Age: " + ageSummaryStats.getMaxAge() + " Avg Age: " + ageSummaryStats.getAgeAvg());

        ActCustCountNames actCustCountNames = service.findActCustCountAndNames();
        System.out.println("Act Cust Count and List of Act Names- 1.4.8_teeing - Count: " + actCustCountNames.getActCustCount() + " Act Names: " + actCustCountNames.getActCustNames());
        //service.differenceFindFirstAny();

        System.out.println(" Commit to check gitRepo: ");
    }
}
