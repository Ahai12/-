package com.ljh.commons.pojo;

public class Customer {
    private String customerName;
    private String customerAddress;
    private Integer customerId;
    private Integer customerTicket;

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerId=" + customerId +
                ", customerTicket=" + customerTicket +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerTicket() {
        return customerTicket;
    }

    public void setCustomerTicket(Integer customerTicket) {
        this.customerTicket = customerTicket;
    }
}
