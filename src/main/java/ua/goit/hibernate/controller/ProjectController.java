package ua.goit.hibernate.controller;

import ua.goit.hibernate.config.HibernateProvider;
import ua.goit.hibernate.model.dto.ProjectDto;
import ua.goit.hibernate.repository.ProjectRepository;
import ua.goit.hibernate.service.ProjectService;
import ua.goit.hibernate.service.convert.ProjectConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = "/projects/*")
public class ProjectController extends HttpServlet {
    private ProjectService projectsService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        ProjectRepository projectsRepository = new ProjectRepository(dbProvider);
        ProjectConverter projectsConverter = new ProjectConverter();
        projectsService = new ProjectService(projectsRepository, projectsConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<ProjectDto> projects = projectsService.findAll();
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("/view/findAllProjects.jsp").forward(req, resp);
        } else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/find")) {
            try {
                int projectId = Integer.parseInt(req.getParameter("projectId"));
                ProjectDto projectById = projectsService.findById(projectId);
                if (projectById.equals(new ProjectDto())) {
                    String message = String.format("Project with ID %s not found", projectId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findProject.jsp").forward(req, resp);
                } else {
                    req.setAttribute("project", projectById);
                    req.getRequestDispatcher("/view/findProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findProject.jsp").forward(req, resp);
            }
        } else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/delete")) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            try {
                String projectName = req.getParameter("projectName");
                int cost = Integer.parseInt(req.getParameter("cost"));
                LocalDate dateOfCreation = LocalDate.parse(req.getParameter("dateOfCreation"));
                ProjectDto project = new ProjectDto(projectName,  cost, dateOfCreation);
                if (!project.getProjectName().isBlank() || Objects.isNull(project.getDateOfCreation())) {
                    ProjectDto savedProject = projectsService.save(project);
                    req.setAttribute("savedProject", savedProject);
                    req.setAttribute("message", "Project added");
                    req.getRequestDispatcher("/view/addProject.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Project not added");
                    req.getRequestDispatcher("/view/addProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/addProject.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int projectId = Integer.parseInt(req.getParameter("projectId"));
                String projectName = req.getParameter("projectName");
                int cost = Integer.parseInt(req.getParameter("cost"));
                LocalDate dateOfCreation = LocalDate.parse(req.getParameter("dateOfCreation"));
                ProjectDto project = new ProjectDto(projectId, projectName,  cost, dateOfCreation);
                if (!project.getProjectName().isBlank() || Objects.isNull(project.getDateOfCreation())) {
                    ProjectDto updatedProject = projectsService.update(project);
                    req.setAttribute("updatedProject", updatedProject);
                    req.setAttribute("message", "Project updated");
                    req.getRequestDispatcher("/view/updateProject.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Project not updated");
                    req.getRequestDispatcher("/view/updateProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateProject.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int projectId = Integer.parseInt(req.getParameter("projectId"));
            ProjectDto project = projectsService.findById(projectId);
            String message;
            if (project.equals(new ProjectDto())) {
                message = String.format("Project with ID %s not found", projectId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteProject.jsp").forward(req, resp);
            } else {
                message = String.format("Project with ID %s deleted", projectId);
                req.setAttribute("developer", project);
                req.setAttribute("message", message);
                projectsService.delete(project);
                req.getRequestDispatcher("/view/deleteProject.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteProject.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
