package ua.goit.hibernate.service;

import ua.goit.hibernate.model.dao.SkillDao;
import ua.goit.hibernate.model.dto.SkillDto;
import ua.goit.hibernate.repository.SkillRepository;
import ua.goit.hibernate.service.convert.SkillConverter;

import java.util.ArrayList;
import java.util.List;

public class SkillService implements Service<SkillDto> {
    private final SkillRepository skillsRepository;
    private final SkillConverter skillsConverter;

    public SkillService(SkillRepository skillsRepository, SkillConverter skillsConverter) {
        this.skillsRepository = skillsRepository;
        this.skillsConverter = skillsConverter;
    }

    @Override
    public SkillDto save(SkillDto entity) {
        SkillDao savedSkill = skillsRepository.save(skillsConverter.to(entity));
        return skillsConverter.from(savedSkill);
    }

    @Override
    public SkillDto update(SkillDto entity) {
        SkillDao updatedSkill = skillsRepository.update(skillsConverter.to(entity));
        return skillsConverter.from(updatedSkill);
    }

    @Override
    public void delete(SkillDto entity) {
        skillsRepository.delete(skillsConverter.to(entity));
    }

    @Override
    public SkillDto findById(Integer id) {
        SkillDao byId = skillsRepository.findById(id);
        return skillsConverter.from(byId);
    }

    @Override
    public List<SkillDto> findAll() {
        List<SkillDto> skillsDtoList = new ArrayList<>();
        List<SkillDao> skillsDaoList = skillsRepository.findAll();
        for (SkillDao dao: skillsDaoList) {
            skillsDtoList.add(skillsConverter.from(dao));
        }
        return skillsDtoList;
    }
}
