package com.soma.customercrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.soma.customercrud.model.Customer;
import com.soma.customercrud.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/")
	public ModelAndView getCustomersList() {
		ModelAndView view = new ModelAndView("customerlist.html");
		List<Customer> customers = customerServiceImpl.getCustomers();
		view.addObject("customers", customers);
		return view;
	}
	
	@GetMapping("/customerform")
	public ModelAndView showCustomerForm() {
		ModelAndView view = new ModelAndView("customerform.html");
		Customer customer = new Customer();
		view.addObject("customer", customer);
		return view;
	}
	
	@PostMapping("/customerform")
	public String customerFormDetails(@ModelAttribute("customer") Customer customer) {
		Customer c = customerServiceImpl.saveCustomer(customer);
		return "redirect:/";
	}
	
	@GetMapping("/customer/{id}")
	public ModelAndView showCustomerDetail(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("customerdetail.html");
		Customer customer = customerServiceImpl.getCustomer(id);
		view.addObject("customer", customer);
		return view;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerServiceImpl.deleteCustomer(id);
		return "redirect:/";
	}
	
	@GetMapping("/updateform/{id}")
	public ModelAndView updateForm(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("updateform.html");
		Customer customer = customerServiceImpl.getCustomer(id);
		view.addObject("customer", customer);
		return view;
	}
	
	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		customerServiceImpl.updateCustomer(customer);
		return "redirect:/";
	}

}
