package ua.goit.hibernate.model.dto;

import java.util.Objects;

public class DeveloperDto {
    private Integer id;
    private String developerName;
    private Integer age;
    private Integer salary;

    public DeveloperDto(Integer id, String developerName, Integer age, Integer salary) {
        this.id = id;
        this.developerName = developerName;
        this.age = age;
        this.salary = salary;
    }

    public DeveloperDto(String developerName, Integer age, Integer salary) {
        this.developerName = developerName;
        this.age = age;
        this.salary = salary;
    }

    public DeveloperDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperDto that = (DeveloperDto) o;
        return Objects.equals(id, that.id) && Objects.equals(developerName, that.developerName) && Objects.equals(age, that.age) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, developerName, age, salary);
    }
}
