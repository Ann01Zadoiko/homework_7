package ua.goit.hibernate.service.convert;


import ua.goit.hibernate.model.dao.CompanyDao;
import ua.goit.hibernate.model.dto.CompanyDto;
import ua.goit.hibernate.service.convert.Converter;

public class CompanyConverter implements Converter<CompanyDto, CompanyDao> {
    @Override
    public CompanyDto from(CompanyDao entity) {
        CompanyDto dto = new CompanyDto();
        dto.setId(entity.getId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    @Override
    public CompanyDao to(CompanyDto entity) {
        CompanyDao dao = new CompanyDao();
        dao.setId(entity.getId());
        dao.setCompanyName(entity.getCompanyName());
        dao.setCountry(entity.getCountry());
        return dao;
    }
}
