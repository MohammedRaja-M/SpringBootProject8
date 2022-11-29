package com.springboot.exapmple.present.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.exapmple.present.model.Customer;
import com.springboot.exapmple.present.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCustomer", customerService.getAllCustomer());
        return "Index";
    }

    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
    	Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    	customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

    	Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);
        return "update_customer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id) {

        this.customerService.deleteCustomerById(id);
        return "redirect:/";
    }
}
