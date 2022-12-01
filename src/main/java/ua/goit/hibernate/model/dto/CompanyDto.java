package ua.goit.hibernate.model.dto;

import java.util.Objects;

public class CompanyDto {
    private Integer id;
    private String CompanyName;
    private String country;

    public CompanyDto(Integer id, String companyName, String country) {
        this.id = id;
        CompanyName = companyName;
        this.country = country;
    }

    public CompanyDto(String companyName, String country) {
        CompanyName = companyName;
        this.country = country;
    }

    public CompanyDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
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
        CompanyDto that = (CompanyDto) o;
        return Objects.equals(id, that.id) && Objects.equals(CompanyName, that.CompanyName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CompanyName, country);
    }
}
