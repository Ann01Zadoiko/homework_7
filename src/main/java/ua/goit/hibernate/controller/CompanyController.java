package ua.goit.hibernate.controller;

import ua.goit.hibernate.config.HibernateProvider;
import ua.goit.hibernate.model.dto.CompanyDto;
import ua.goit.hibernate.repository.CompanyRepository;
import ua.goit.hibernate.service.CompanyService;
import ua.goit.hibernate.service.convert.CompanyConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/companies/*")
public class CompanyController extends HttpServlet {
    private CompanyService companiesService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        CompanyRepository companiesRepository = new CompanyRepository(dbProvider);
        CompanyConverter companiesConverter = new CompanyConverter();
        companiesService = new CompanyService(companiesRepository, companiesConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<CompanyDto> companies = companiesService.findAll();
            req.setAttribute("companies", companies);
            req.getRequestDispatcher("/view/findAllCompanies.jsp").forward(req, resp);
        }
        else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findCompanyForm.jsp").forward(req, resp);
        }
        else if (action.matches("/find")) {
            try {
                int companyId = Integer.parseInt(req.getParameter("companyId"));
                CompanyDto companyById = companiesService.findById(companyId);
                if (companyById.equals(new CompanyDto())) {
                    String message = String.format("Company with ID %s not found", companyId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findCompany.jsp").forward(req, resp);
                } else {
                    req.setAttribute("company", companyById);
                    req.getRequestDispatcher("/view/findCompany.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findCompany.jsp").forward(req, resp);
            }
        }
        else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addCompanyForm.jsp").forward(req, resp);
        }
        else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateCompanyForm.jsp").forward(req, resp);
        }
        else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteCompanyForm.jsp").forward(req, resp);
        }
        else if (action.matches("/delete")) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            String companyName = req.getParameter("companyName");
            String country = req.getParameter("country");
            CompanyDto company = new CompanyDto(companyName, country);
            if (!company.getCompanyName().isBlank() || !company.getCountry().isBlank() ) {
                CompanyDto savedCompany = companiesService.save(company);
                req.setAttribute("savedCompany", savedCompany);
                req.setAttribute("message", "Company added");
                req.getRequestDispatcher("/view/addCompany.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Company not added");
                req.getRequestDispatcher("/view/addCompany.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int companyId = Integer.parseInt(req.getParameter("companyId"));
                String companyName = req.getParameter("companyName");
                String country = req.getParameter("country");
                CompanyDto company = new CompanyDto(companyId, companyName, country);
                if (!company.getCompanyName().isBlank() || !company.getCountry().isBlank() ) {
                    CompanyDto updatedCompany = companiesService.update(company);
                    req.setAttribute("updatedCompany", updatedCompany);
                    req.setAttribute("message", "Company updated");
                    req.getRequestDispatcher("/view/updateCompany.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Company not updated");
                    req.getRequestDispatcher("/view/updateCompany.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateCompany.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int companyId = Integer.parseInt(req.getParameter("companyId"));
            CompanyDto company = companiesService.findById(companyId);
            String message;
            if (company.equals(new CompanyDto())) {
                message = String.format("Company with ID %s not found", companyId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteCompany.jsp").forward(req, resp);
            } else {
                message = String.format("Company with ID %s deleted", companyId);
                req.setAttribute("company", company);
                req.setAttribute("message", message);
                companiesService.delete(company);
                req.getRequestDispatcher("/view/deleteCompany.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteCompany.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
