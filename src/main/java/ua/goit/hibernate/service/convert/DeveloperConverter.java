package ua.goit.hibernate.service.convert;

import ua.goit.hibernate.model.dao.DeveloperDao;
import ua.goit.hibernate.model.dto.DeveloperDto;

public class DeveloperConverter implements Converter<DeveloperDto, DeveloperDao> {
    @Override
    public DeveloperDto from(DeveloperDao entity) {
        DeveloperDto dto = new DeveloperDto();
        dto.setId(entity.getId());
        dto.setDeveloperName(entity.getDeveloperName());
        dto.setAge(entity.getAge());
        dto.setSalary(entity.getSalary());
        return dto;
    }

    @Override
    public DeveloperDao to(DeveloperDto entity) {
        DeveloperDao dao = new DeveloperDao();
        dao.setId(entity.getId());
        dao.setDeveloperName(entity.getDeveloperName());
        dao.setAge(entity.getAge());
        dao.setSalary(entity.getSalary());
        return dao;
    }
}
