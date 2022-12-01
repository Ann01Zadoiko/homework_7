package ua.goit.hibernate.service;

import ua.goit.hibernate.model.dao.ProjectDao;
import ua.goit.hibernate.model.dto.ProjectDto;
import ua.goit.hibernate.repository.ProjectRepository;
import ua.goit.hibernate.service.convert.ProjectConverter;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements Service<ProjectDto> {
    private final ProjectRepository projectsRepository;
    private final ProjectConverter projectsConverter;

    public ProjectService(ProjectRepository projectsRepository, ProjectConverter projectsConverter) {
        this.projectsRepository = projectsRepository;
        this.projectsConverter = projectsConverter;
    }

    @Override
    public ProjectDto save(ProjectDto dto) {
        ProjectDao savedProject = projectsRepository.save(projectsConverter.to(dto));
        return projectsConverter.from(savedProject);
    }

    @Override
    public ProjectDto update(ProjectDto dto) {
        ProjectDao project = projectsRepository.update(projectsConverter.to(dto));
        return projectsConverter.from(project);
    }

    @Override
    public void delete(ProjectDto dto) {
        projectsRepository.delete(projectsConverter.to(dto));
    }

    @Override
    public ProjectDto findById(Integer id) {
        ProjectDao byId = projectsRepository.findById(id);
        return projectsConverter.from(byId);
    }

    @Override
    public List<ProjectDto> findAll() {
        List<ProjectDto> projectsDtoList = new ArrayList<>();
        List<ProjectDao> projectsDaoList = projectsRepository.findAll();
        for (ProjectDao dao: projectsDaoList) {
            projectsDtoList.add(projectsConverter.from(dao));
        }
        return projectsDtoList;
    }

}
