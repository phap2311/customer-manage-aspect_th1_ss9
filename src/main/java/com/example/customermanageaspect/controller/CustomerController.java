package com.example.customermanageaspect.controller;

import com.example.customermanageaspect.model.Customer;
import com.example.customermanageaspect.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ModelAndView showList() {
        try {
            ModelAndView modelAndView = new ModelAndView("/list");
            Iterable<Customer> customers = iCustomerService.findAll();
            modelAndView.addObject("customer", customers);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customer");
        }

    }


    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes) {
        iCustomerService.save(customer);
        attributes.addFlashAttribute("message", "create new customer");
        return "redirect:/customer";
    }

    @GetMapping("update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        try {
            Optional<Customer> customer = iCustomerService.findById(id);
            if (customer.isPresent()) {
                ModelAndView modelAndView = new ModelAndView("/update");
                modelAndView.addObject("customer", customer.get());
                return modelAndView;
        }

        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }

        return null;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes) {
        iCustomerService.save(customer);
        attributes.addFlashAttribute("success", "edit customer success");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        iCustomerService.remove(id);
        attributes.addFlashAttribute("success","delete customer successfully");
return "redirect: /customer";
    }


}




