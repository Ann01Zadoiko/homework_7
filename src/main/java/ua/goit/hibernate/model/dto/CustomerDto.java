package ua.goit.hibernate.model.dto;

import java.util.Objects;

public class CustomerDto {
    private Integer id;
    private String customerName;
    private String country;

    public CustomerDto(Integer id, String customerName, String country) {
        this.id = id;
        this.customerName = customerName;
        this.country = country;
    }

    public CustomerDto(String customerName, String country) {
        this.customerName = customerName;
        this.country = country;
    }

    public CustomerDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(id, that.id) && Objects.equals(customerName, that.customerName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, country);
    }
}
