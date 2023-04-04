package com.soma.customercrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soma.customercrud.model.Customer;
import com.soma.customercrud.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);	
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);	
	}

}
