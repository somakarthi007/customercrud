package com.soma.customercrud.service;

import java.util.List;

import com.soma.customercrud.model.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomer(Long id);
	
	public void deleteCustomer(Long id);
	
	public Customer updateCustomer(Customer customer);

}
