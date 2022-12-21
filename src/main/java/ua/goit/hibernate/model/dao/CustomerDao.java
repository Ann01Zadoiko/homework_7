package ua.goit.hibernate.model.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class CustomerDao {
    Integer id;
    String customerName;
    String country;
    Set<ProjectDao> projects;

    public CustomerDao() {}

    public CustomerDao(Integer id, String customerName, String country) {
        this.id = id;
        this.customerName = customerName;
        this.country = country;
    }

    public CustomerDao(String customerName, String country) {
        this.customerName = customerName;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name_customer", length = 45)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "country", length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ManyToMany
    @JoinTable(name = "customers_projects",
            joinColumns = {@JoinColumn(name = "id_customer")},
            inverseJoinColumns = {@JoinColumn(name = "id_project")})
    public Set<ProjectDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDao> projects) {
        this.projects = projects;
    }
}
