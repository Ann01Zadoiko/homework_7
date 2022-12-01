package ua.goit.hibernate.model.dao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projects")
public class ProjectDao {
    Integer id;
    String projectName;
    Integer cost;
    LocalDate dateOfCreation;
    Set<DeveloperDao> developers;
    Set<CompanyDao> companies;
    Set<CustomerDao> customers;

    public ProjectDao() {
    }

    public ProjectDao(Integer id, String projectName, Integer cost, LocalDate dateOfCreation) {
        this.id = id;
        this.projectName = projectName;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDao(String projectName, String projectType, String comments, Integer cost, LocalDate dateOfCreation) {
        this.projectName = projectName;

        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name_project", length = 45)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column(name = "date_of_creation")
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @ManyToMany
    @JoinTable(name = "developer_projects",
            joinColumns = {@JoinColumn(name = "id_project")},
            inverseJoinColumns = {@JoinColumn(name = "id_developer")})
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    @ManyToMany(mappedBy = "projects")
    public Set<CompanyDao> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompanyDao> companies) {
        this.companies = companies;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }

    @ManyToMany(mappedBy = "projects")
    public Set<CustomerDao> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerDao> customers) {
        this.customers = customers;
    }

}
