package com.spring.pos.service.impl;

import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.dto.request.CustomerUpdateDTO;
import com.spring.pos.entity.Customer;
import com.spring.pos.repo.CustomerRepo;
import com.spring.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerupdateDTO) {
        if(customerRepo.existsById(customerupdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerupdateDTO.getCustomerId());

            customer.setCustomerName(customerupdateDTO.getCustomerName());
            customer.setCustomerAddress(customerupdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerupdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerupdateDTO.getCustomerName()+"Update Successfull";

        }else{
            throw new RuntimeException("No data found for the id");
        }


    }

    @Override
    public CustomerDTO getCustomerByID(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;

        }else{
            throw new RuntimeException("No customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList =  new ArrayList<>();
        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return  "Deleted";
        }else {
            throw new RuntimeException("Not found");

        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {

        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);


        List<CustomerDTO> customerDTOList =  new ArrayList<>();
        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }


}


