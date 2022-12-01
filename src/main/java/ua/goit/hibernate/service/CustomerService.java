package ua.goit.hibernate.service;

import ua.goit.hibernate.model.dao.CustomerDao;
import ua.goit.hibernate.model.dto.CustomerDto;
import ua.goit.hibernate.repository.CustomerRepository;
import ua.goit.hibernate.service.convert.CustomerConverter;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements Service<CustomerDto> {
    private final CustomerRepository customersRepository;
    private final CustomerConverter customersConverter;

    public CustomerService(CustomerRepository customersRepository, CustomerConverter customersConverter) {
        this.customersRepository = customersRepository;
        this.customersConverter = customersConverter;
    }

    @Override
    public CustomerDto save(CustomerDto entity) {
        CustomerDao savedCustomer = customersRepository.save(customersConverter.to(entity));
        return customersConverter.from(savedCustomer);
    }

    @Override
    public CustomerDto update(CustomerDto entity) {
        CustomerDao updatedCustomer = customersRepository.update(customersConverter.to(entity));
        return customersConverter.from(updatedCustomer);
    }

    @Override
    public void delete(CustomerDto entity) {
        customersRepository.delete(customersConverter.to(entity));
    }

    @Override
    public CustomerDto findById(Integer id) {
        CustomerDao byId = customersRepository.findById(id);
        return customersConverter.from(byId);
    }

    @Override
    public List<CustomerDto> findAll() {
        List<CustomerDto> customersDtoList = new ArrayList<>();
        List<CustomerDao> customersDaoList = customersRepository.findAll();
        for (CustomerDao dao: customersDaoList) {
            customersDtoList.add(customersConverter.from(dao));
        }
        return customersDtoList;
    }
}
