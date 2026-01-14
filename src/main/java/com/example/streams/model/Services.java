package main.java.com.example.streams.model;

public class Services {
    public long id;
    public String serviceName;
    public String serviceType;
    public double servicePrice;

    public Services(long id, String serviceName, String serviceType, double servicePrice) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
    }

    public long getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getServicePrice() {
        return servicePrice;
    }
}
