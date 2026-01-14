package main.java.com.example.streams.service;


import main.java.com.example.streams.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerService {

    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    // List active customers
    public List<Customer> getActiveCustomers() {
        return customers.stream()
                .filter(Customer::isActive)
                .toList();
    }

    // List customers older than 30
    public List<String> getCustomerNamesOlderThan30() {
        return customers.stream()
                .filter(c -> c.getAge() > 30)
                .map(Customer::getName)
                .toList();
    }

    // List all services types of all customers
    public Set<String> getAllUniqueServices() {
        return customers.stream()
                .flatMap(c -> c.getServices().stream())
                .collect(Collectors.toSet());
    }

    // List all services types of all customers
    public List<String> getAllServices() {
        return customers.stream()
                .flatMap(c -> c.getServices().stream())
                .collect(Collectors.toList());
    }


    // Find the oldest customer
    public Optional<Customer> getOldestCustomer() {
        return customers.stream()
                .max((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()));
    }

    // List female customers:
    public List<String> getFemaleCustomers() {
        return customers.stream()
                .filter(c -> c.getGender() == Gender.FEMALE)
                .map(c -> c.getName())
                .toList();
    }

    // List female customers:
    public List<Customer> denemeReduce() {
        return customers.stream()
                .filter(c -> c.getGender() == Gender.FEMALE)
                .toList();
                //.reduce();
    }

    // Find first female customer:
    public Optional<String> findFirstCustomer() {
        return customers.stream()
                .filter(c -> c.getGender() == Gender.FEMALE)
                .map(c -> c.getName())
                .findFirst();
    }

    // Find x male customer:
    public Optional<String> findXMaleCustomer(int x) {
        return customers.stream()
                .filter(c -> c.getGender() == Gender.MALE)
                .map(c -> c.getName())
                .findAny();
    }

    public void differenceFindFirstAny() {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    customers.parallelStream()
                            .filter(c -> c.getGender() == Gender.MALE)
                            .map(Customer::getName)
                            .unordered()
                            .findAny()
                            .orElse("none")
            );
        }
    }

    // Find the youngest customer's name
    public String getYoungestCustomerName() {
        return customers.stream()
                .min((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()))
                .map(c -> c.getName())
                .orElse("");
    }

    // Is there any active customers
    public boolean hasAnyActiveCustomer() {
        return customers.stream()
                .anyMatch(Customer::isActive);
    }

    // Find the count of active customers
    public int activeCustomersCount() {
        return (int) customers.stream()
                .filter(Customer::isActive)
                .count();
    }

    // Find count of male customers
    public int countOfMaleCustomers(){
        return (int) customers.stream()
                .filter(a -> a.getGender() == Gender.MALE)
                .count();

    }

    // Find count of male active customers
    public int countOfMaleActiveCustomers() {
        return (int) customers.stream()
                .filter(c -> c.getGender() == Gender.MALE)
                .filter(Customer::isActive)
                .count();
    }

    // List male active customers
    public List<String> getActiveMaleCustomerNames() {
        return customers.stream()
                .filter(c -> c.getGender() == Gender.MALE && c.isActive())
                .map(Customer::getName)
                .toList();
    }

    // get age avg of all customers
    public double avgAgeOfAllCustomers() {
        return customers.stream()
                .mapToDouble(Customer::getAge)
                .average()
                .orElse(0.0);
    }

    // List male active customers
    public double averageAgeOfActiveMaleCustomers() {
        return customers.stream()
                .filter(c -> c.getGender() == Gender.MALE && c.isActive())
                .mapToDouble(Customer::getAge)
                .average()
                .orElse(0.0);
    }

    //Find the average age of all inactive customers
    public double averageAgeOfInactiveCustomers() {
        return customers.stream()
                .filter(c -> !c.isActive())
                .mapToDouble(Customer::getAge)
                .average().
                orElse(0.0);

    }

    //Test case
    public List<String> getActiveCustomersNames(){
        return customers.stream()
                .filter(c -> c.isActive())
                .map(c -> c.getName())
                .toList();
    }

    //İsim sayilari
    public int[] getNameLength(){
        return customers.stream()
                .mapToInt(c -> c.getName().length())
                .toArray();
    }

    //Longest Customer Name
    public int[] getLongestName(){
        return customers.stream()
                .mapToInt(c -> c.getName().length())
                .toArray();
    }

    //Group customers by gender
    public Map<Gender, List<Customer>> groupCustomersByGender() {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getGender));
    }

    //Group customers by activate
    public Map<Boolean, Long> groupCustomersByActive() {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::isActive, Collectors.counting()));
    }

    //Group customers by activate2
    public Map<Boolean, Long> groupCustomersByActive2() {
        return customers.stream()
                .collect(Collectors.partitioningBy(Customer::isActive, Collectors.counting()));
    }

    //Group active customers by gender
    public Map<Gender, Long> groupActiveCustomersByGender() {
        return customers.stream()
                .filter(c -> c.isActive())
                .collect(Collectors.groupingBy(Customer::getGender, Collectors.counting()));
    }

    public Map<Gender, Map<Boolean, Long>> countActivePassiveCustomersByGender() {
        return customers.stream()
                .collect(Collectors.groupingBy(
                        Customer::getGender,
                        Collectors.groupingBy(Customer::isActive, Collectors.counting())));
    }

    public CustomerStats getCustomerCountAndAverageAge() {
        return customers.stream()
                .collect(Collectors.teeing(
                        Collectors.counting(),                       // 1️⃣ kaç müşteri var
                        Collectors.averagingInt(Customer::getAge),   // 2️⃣ yaş ortalaması
                        (count, avgAge) -> new CustomerStats(count, avgAge)
                ));
    }

    public Map<Boolean, CustomerStats> getActivePassiveStats() {
        return customers.stream()
                .collect(
                        Collectors.partitioningBy(
                                Customer::isActive, Collectors.teeing(
                                        Collectors.counting(),
                                        Collectors.averagingInt(Customer::getAge),
                                        (count, avgAge) -> new CustomerStats(count, avgAge)
                                )
                ));
    }

    //Group active/passive customers Example 1.4.5: with partitioningBy
    public Map<Boolean, Long> countActivePassiveCustomersByPartitioning() {
        return customers.stream()
                .collect(Collectors.partitioningBy(Customer::isActive, Collectors.counting()));
    }

    //Group active/passive customers Example 1.4.5: with teeing
    public ActivePassiveCount countActivePassiveCustomersByTeeing() {
        return customers.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(Customer::isActive, Collectors.counting()),
                        Collectors.filtering(c -> !c.isActive(), Collectors.counting()),
                        ActivePassiveCount::new
                ));
    }

    //Group gender of the customer customers by gender Example 1.4.6: with teeing
    public GenderCountStats countByGenderByTeeing() {
        return customers.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(c -> c.getGender() == Gender.MALE, Collectors.counting()),
                        Collectors.filtering(c -> c.getGender() == Gender.FEMALE, Collectors.counting()),
                        (a, b)-> new GenderCountStats(a,b)
                ));
    }

    //Count active customers by gender Example 1.4.7: with teeing
    public GenderActiveCountStats countActiveCustomersByGenderByTeeing() {
        return customers.stream()
                .filter(Customer::isActive)
                .collect(Collectors.teeing(
                        Collectors.filtering(c -> c.getGender() == Gender.FEMALE, Collectors.counting()),
                        Collectors.filtering(c -> c.getGender() == Gender.MALE, Collectors.counting()),
                        GenderActiveCountStats::new
                ));
    }

    //Avg age + max Age  Example 1.4.8: with teeing
    public AgeSummaryStats findAgeSummaryByTeeing() {
        return customers.stream()
                .collect(Collectors.teeing(
                        Collectors.averagingInt(Customer::getAge),
                        Collectors.mapping(Customer::getAge, Collectors.maxBy(Integer::compare)),
                        (a,max) -> new AgeSummaryStats(a, max.orElse(0))

                ));
    }

    //Active Customers Count and List of Active Customers Names - 1.4.9: teeing
    public ActCustCountNames findActCustCountAndNames() {
        return customers.stream()
                .filter(Customer::isActive)
                .collect(Collectors.teeing(
                        Collectors.counting(),                         // R1 = Long
                        Collectors.mapping(                            // R2 = List<String>
                                Customer::getName,
                                Collectors.toList()
                        ),
                        (count, names) -> new ActCustCountNames(count.intValue(), names)                     // (Long, List<String>) -> model
                ));

    }

}
