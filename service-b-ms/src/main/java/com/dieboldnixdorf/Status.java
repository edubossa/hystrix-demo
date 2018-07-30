package com.dieboldnixdorf;

public class Status {

    private String status;
    private String serviceName;

    public Status(String status, String serviceName) {
        this.status = status;
        this.serviceName = serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
