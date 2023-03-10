package ua.goit.hibernate.service;

import ua.goit.hibernate.exceptions.DeveloperAlreadyExistException;
import ua.goit.hibernate.model.dao.DeveloperDao;
import ua.goit.hibernate.model.dao.ProjectDao;
import ua.goit.hibernate.model.dto.DeveloperDto;
import ua.goit.hibernate.repository.DeveloperRepository;
import ua.goit.hibernate.service.convert.DeveloperConverter;

import java.util.ArrayList;
import java.util.List;

public class DeveloperService implements Service<DeveloperDto> {
    private final DeveloperRepository developersRepository;
    private final DeveloperConverter developersConverter;

    public DeveloperService(DeveloperRepository developersRepository, DeveloperConverter developersConverter) {
        this.developersRepository = developersRepository;
        this.developersConverter = developersConverter;
    }

    @Override
    public DeveloperDto save(DeveloperDto dto) {
        DeveloperDao savedProject = developersRepository.save(developersConverter.to(dto));
        return developersConverter.from(savedProject);
    }

    @Override
    public DeveloperDto update(DeveloperDto dto) {
        DeveloperDao dao = developersRepository.update(developersConverter.to(dto));
        return developersConverter.from(dao);
    }

    @Override
    public void delete(DeveloperDto dto) {
        developersRepository.delete(developersConverter.to(dto));
    }

    @Override
    public DeveloperDto findById(Integer id) {
        DeveloperDao byId = developersRepository.findById(id);
        return developersConverter.from(byId);
    }

    @Override
    public List<DeveloperDto> findAll() {
        List<DeveloperDto> developersDtoList = new ArrayList<>();
        List<DeveloperDao> developersDaoList = developersRepository.findAll();
        for (DeveloperDao dao : developersDaoList) {
            developersDtoList.add(developersConverter.from(dao));
        }
        return developersDtoList;
    }

}
