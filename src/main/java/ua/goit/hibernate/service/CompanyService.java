package ua.goit.hibernate.service;

import ua.goit.hibernate.model.dao.CompanyDao;
import ua.goit.hibernate.model.dto.CompanyDto;
import ua.goit.hibernate.repository.CompanyRepository;
import ua.goit.hibernate.service.convert.CompanyConverter;

import java.util.ArrayList;
import java.util.List;

public class CompanyService implements Service<CompanyDto> {
    private final CompanyRepository companiesRepository;
    private final CompanyConverter companiesConverter;

    public CompanyService(CompanyRepository companiesRepository,CompanyConverter companiesConverter) {
        this.companiesRepository = companiesRepository;
        this.companiesConverter = companiesConverter;
    }

    @Override
    public CompanyDto save(CompanyDto entity) {
        CompanyDao savedCompany = companiesRepository.save(companiesConverter.to(entity));
        return companiesConverter.from(savedCompany);
    }

    @Override
    public CompanyDto update(CompanyDto entity) {
        CompanyDao updatedCompany = companiesRepository.update(companiesConverter.to(entity));
        return companiesConverter.from(updatedCompany);
    }

    @Override
    public void delete(CompanyDto entity) {
        companiesRepository.delete(companiesConverter.to(entity));
    }

    @Override
    public CompanyDto findById(Integer id) {
        CompanyDao byId = companiesRepository.findById(id);
        return companiesConverter.from(byId);
    }

    @Override
    public List<CompanyDto> findAll() {
        List<CompanyDto> companiesDtoList = new ArrayList<>();
        List<CompanyDao> companiesDaoList = companiesRepository.findAll();
        for (CompanyDao dao: companiesDaoList) {
            companiesDtoList.add(companiesConverter.from(dao));
        }
        return companiesDtoList;
    }
}
