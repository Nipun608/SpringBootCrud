package com.spring.pos.service;

import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
     public String saveCustomer(CustomerDTO customerDTO);


    String updateCustomer(CustomerUpdateDTO customerupdateDTO);

    CustomerDTO getCustomerByID(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
