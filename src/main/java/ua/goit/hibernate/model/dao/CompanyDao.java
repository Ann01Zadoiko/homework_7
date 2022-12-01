package ua.goit.hibernate.model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyDao {
    Integer id;
    String companyName;
    String country;
    Set<ProjectDao> projects;

    public CompanyDao() {}

    public CompanyDao(Integer id, String companyName, String country) {
        this.id = id;
        this.companyName = companyName;
        this.country = country;
    }

    public CompanyDao(String companyName, String country) {
        this.companyName = companyName;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name_company", length = 45)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "country", length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ManyToMany
    @JoinTable(name = "companies_projects",
            joinColumns = {@JoinColumn(name = "id_company")},
            inverseJoinColumns = {@JoinColumn(name = "id_project")})
    public Set<ProjectDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDao> projects) {
        this.projects = projects;
    }

}
