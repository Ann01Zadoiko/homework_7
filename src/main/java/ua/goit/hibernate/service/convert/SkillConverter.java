package ua.goit.hibernate.service.convert;

import ua.goit.hibernate.model.dao.SkillDao;
import ua.goit.hibernate.model.dto.SkillDto;

public class SkillConverter implements Converter<SkillDto, SkillDao> {
    @Override
    public SkillDto from(SkillDao entity) {
        SkillDto dto = new SkillDto();
        dto.setId(entity.getId());
        dto.setProgrammingLanguage(entity.getProgrammingLanguage());
        dto.setSkillLevel(entity.getSkillLevel());
        return dto;
    }

    @Override
    public SkillDao to(SkillDto entity) {
        SkillDao dao = new SkillDao();
        dao.setId(entity.getId());
        dao.setProgrammingLanguage(entity.getProgrammingLanguage());
        dao.setSkillLevel(entity.getSkillLevel());
        return dao;
    }
}
