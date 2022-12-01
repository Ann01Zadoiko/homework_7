package ua.goit.hibernate.service.convert;


import ua.goit.hibernate.model.dao.CustomerDao;
import ua.goit.hibernate.model.dto.CustomerDto;

public class CustomerConverter implements Converter<CustomerDto, CustomerDao> {
    @Override
    public CustomerDto from(CustomerDao entity) {
        CustomerDto dto = new CustomerDto();
        dto.setId(entity.getId());
        dto.setCustomerName(entity.getCustomerName());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    @Override
    public CustomerDao to(CustomerDto entity) {
        CustomerDao dao = new CustomerDao();
        dao.setId(entity.getId());
        dao.setCustomerName(entity.getCustomerName());
        dao.setCountry(entity.getCountry());
        return dao;
    }
}
