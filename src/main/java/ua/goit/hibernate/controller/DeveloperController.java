package ua.goit.hibernate.controller;

import ua.goit.hibernate.config.HibernateProvider;
import ua.goit.hibernate.model.dto.DeveloperDto;
import ua.goit.hibernate.repository.DeveloperRepository;
import ua.goit.hibernate.service.DeveloperService;
import ua.goit.hibernate.service.convert.DeveloperConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/*")
public class DeveloperController extends HttpServlet {
    private DeveloperService developersService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        DeveloperRepository developersRepository = new DeveloperRepository(dbProvider);
        DeveloperConverter developersConverter = new DeveloperConverter();
        developersService = new DeveloperService(developersRepository, developersConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<DeveloperDto> developers = developersService.findAll();
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("/view/findAllDevelopers.jsp").forward(req, resp);
        } else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/find")) {
            try {
                int developerId = Integer.parseInt(req.getParameter("developerId"));
                DeveloperDto developerById = developersService.findById(developerId);
                if (developerById.equals(new DeveloperDto())) {
                    String message = String.format("Developer with ID %s not found", developerId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findDeveloper.jsp").forward(req, resp);
                } else {
                    req.setAttribute("developer", developerById);
                    req.getRequestDispatcher("/view/findDeveloper.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findDeveloper.jsp").forward(req, resp);
            }
        } else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/delete")) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            try {
                String developerName = req.getParameter("developerName");
                int age = Integer.parseInt(req.getParameter("age"));
                int salary = Integer.parseInt(req.getParameter("salary"));
                DeveloperDto developer = new DeveloperDto(developerName, age,  salary);
                if (!developer.getDeveloperName().isBlank()) {
                    DeveloperDto savedDeveloper = developersService.save(developer);
                    req.setAttribute("savedDeveloper", savedDeveloper);
                    req.setAttribute("message", "Developer added");
                    req.getRequestDispatcher("/view/addDeveloper.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Developer not added");
                    req.getRequestDispatcher("/view/addDeveloper.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/addDeveloper.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int developerId = Integer.parseInt(req.getParameter("developerId"));
                String developerName = req.getParameter("developerName");
                int age = Integer.parseInt(req.getParameter("age"));
                int salary = Integer.parseInt(req.getParameter("salary"));
                DeveloperDto developer = new DeveloperDto(developerId, developerName, age, salary);
                if (!developer.getDeveloperName().isBlank()) {
                    DeveloperDto updatedDeveloper = developersService.update(developer);
                    req.setAttribute("updatedDeveloper", updatedDeveloper);
                    req.setAttribute("message", "Developer updated");
                    req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Developer not updated");
                    req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int developerId = Integer.parseInt(req.getParameter("developerId"));
            DeveloperDto developer = developersService.findById(developerId);
            String message;
            if (developer.equals(new DeveloperDto())) {
                message = String.format("Developer with ID %s not found", developerId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
            } else {
                message = String.format("Developer with ID %s deleted", developerId);
                req.setAttribute("developer", developer);
                req.setAttribute("message", message);
                developersService.delete(developer);
                req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
