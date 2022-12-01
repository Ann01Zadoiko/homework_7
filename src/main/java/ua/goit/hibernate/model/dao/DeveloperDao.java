package ua.goit.hibernate.model.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developers")
public class DeveloperDao {
    Integer id;
    String developerName;
    Integer age;
    Integer salary;
    Set<ProjectDao> projects;
    Set<SkillDao> skills;

    public DeveloperDao() {
    }

    public DeveloperDao(Integer id, String developerName, Integer age, Integer salary) {
        this.id = id;
        this.developerName = developerName;
        this.age = age;
        this.salary = salary;
    }

    public DeveloperDao(String developerName, Integer age, Integer salary) {
        this.developerName = developerName;
        this.age = age;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name_developer", length = 45)
    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @ManyToMany(mappedBy = "developers")
    public Set<ProjectDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDao> projects) {
        this.projects = projects;
    }

    @ManyToMany
    @JoinTable(name = "developer_skills",
            joinColumns = {@JoinColumn(name = "id_developer")},
            inverseJoinColumns = {@JoinColumn(name = "id_skill")})
    public Set<SkillDao> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDao> skills) {
        this.skills = skills;
    }

}
