package ua.goit.hibernate.service.convert;

import ua.goit.hibernate.model.dao.ProjectDao;
import ua.goit.hibernate.model.dto.ProjectDto;

public class ProjectConverter implements Converter<ProjectDto, ProjectDao> {
    @Override
    public ProjectDto from(ProjectDao entity) {
        ProjectDto dto = new ProjectDto();
        dto.setId(entity.getId());
        dto.setProjectName(entity.getProjectName());
        dto.setCost(entity.getCost());
        dto.setDateOfCreation(entity.getDateOfCreation());
        return dto;
    }

    @Override
    public ProjectDao to(ProjectDto entity) {
        ProjectDao dao = new ProjectDao();
        dao.setId(entity.getId());
        dao.setProjectName(entity.getProjectName());
        dao.setCost(entity.getCost());
        dao.setDateOfCreation(entity.getDateOfCreation());
        return dao;
    }
}
