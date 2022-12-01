package ua.goit.hibernate.controller;

import ua.goit.hibernate.config.HibernateProvider;
import ua.goit.hibernate.model.dto.SkillDto;
import ua.goit.hibernate.repository.SkillRepository;
import ua.goit.hibernate.service.SkillService;
import ua.goit.hibernate.service.convert.SkillConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/skills/*")
public class SkillController extends HttpServlet {
    private SkillService skillsService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        SkillRepository skillsRepository = new SkillRepository(dbProvider);
        SkillConverter skillsConverter = new SkillConverter();
        skillsService = new SkillService(skillsRepository, skillsConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<SkillDto> skills = skillsService.findAll();
            req.setAttribute("skills", skills);
            req.getRequestDispatcher("/view/findAllSkills.jsp").forward(req, resp);
        }
        else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findSkillForm.jsp").forward(req, resp);
        }
        else if (action.matches("/find")) {
            try {
                int skillId = Integer.parseInt(req.getParameter("skillId"));
                SkillDto skillById = skillsService.findById(skillId);
                if (skillById.equals(new SkillDto())) {
                    String message = String.format("Skill with ID %s not found", skillId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
                } else {
                    req.setAttribute("skill", skillById);
                    req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
            }
        }
        else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addSkillForm.jsp").forward(req, resp);
        }
        else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateSkillForm.jsp").forward(req, resp);
        }
        else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteSkillForm.jsp").forward(req, resp);
        }
        else if (action.startsWith("/delete")) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            String programmingLanguage = req.getParameter("programmingLanguage");
            String skillLevel = req.getParameter("skillLevel");
            SkillDto skills = new SkillDto(programmingLanguage, skillLevel);
            if (!skills.getProgrammingLanguage().isBlank() || !skills.getSkillLevel().isBlank()) {
                SkillDto savedSkill = skillsService.save(skills);
                req.setAttribute("savedSkill", savedSkill);
                req.setAttribute("message", "Skill added");
                req.getRequestDispatcher("/view/addSkill.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Skill not added");
                req.getRequestDispatcher("/view/addSkill.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int skillId = Integer.parseInt(req.getParameter("skillId"));
                String programmingLanguage = req.getParameter("programmingLanguage");
                String skillLevel = req.getParameter("skillLevel");
                SkillDto skills = new SkillDto(skillId, programmingLanguage, skillLevel);
                if (!skills.getProgrammingLanguage().isBlank() || !skills.getSkillLevel().isBlank()) {
                    SkillDto updatedSkill = skillsService.update(skills);
                    req.setAttribute("updatedSkill", updatedSkill);
                    req.setAttribute("message", "Skill updated");
                    req.getRequestDispatcher("/view/updateSkill.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Skill not updated");
                    req.getRequestDispatcher("/view/updateSkill.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateSkill.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int skillId = Integer.parseInt(req.getParameter("skillId"));
            SkillDto skill = skillsService.findById(skillId);
            String message;
            if (skill.equals(new SkillDto())) {
                message = String.format("Skill with ID %s not found", skillId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteSkill.jsp").forward(req, resp);
            } else {
                message = String.format("Skill with ID %s deleted", skillId);
                req.setAttribute("skill", skill);
                req.setAttribute("message", message);
                skillsService.delete(skill);
                req.getRequestDispatcher("/view/deleteSkill.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteSkill.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
