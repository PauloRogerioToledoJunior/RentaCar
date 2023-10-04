package br.com.jlgregorio.rentacar.services;

import br.com.jlgregorio.rentacar.dto.CustomerDTO;
import br.com.jlgregorio.rentacar.exceptions.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.Customer;
import br.com.jlgregorio.rentacar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerDTO create(CustomerDTO dto) {
        Customer model = CustomModelMapper.parseObject(dto, Customer.class);
        return CustomModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    public CustomerDTO findById(int id) {
        Customer model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(null));
        return CustomModelMapper.parseObject(model, CustomerDTO.class);
    }

    public List<CustomerDTO> findAll(){
        List<Customer> list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, CustomerDTO.class);
    }

    public CustomerDTO update(CustomerDTO dto){
        Customer model = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, Customer.class);
        return CustomModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    public void delete(CustomerDTO dto) {
        Customer model = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        repository.delete(model);
    }
}