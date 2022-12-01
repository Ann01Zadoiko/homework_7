package ua.goit.hibernate.model.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectDto {
    private Integer id;
    private String projectName;
    private Integer cost;
    private LocalDate dateOfCreation;

    public ProjectDto(Integer id, String projectName, Integer cost, LocalDate dateOfCreation) {
        this.id = id;
        this.projectName = projectName;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDto(String projectName, Integer cost, LocalDate dateOfCreation) {
        this.projectName = projectName;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(id, that.id) && Objects.equals(projectName, that.projectName) && Objects.equals(cost, that.cost) && Objects.equals(dateOfCreation, that.dateOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, cost, dateOfCreation);
    }
}
