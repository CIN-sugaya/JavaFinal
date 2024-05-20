package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/admin/contacts")
    public String showContactList(Model model) {
        List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "admin/contact_list";
    }

    @GetMapping("/admin/contacts/{id}")
    public String showContactDetail(@PathVariable("id") Long id, Model model) {
        var contact = contactRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        model.addAttribute("contact", contact);
        return "admin/contact_detail";
    }

    @GetMapping("/admin/contacts/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        model.addAttribute("contact", contact);
        return "admin/contact_edit";
    }

    @PostMapping("/admin/contacts/update")
    public String updateContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/admin/contacts";
    }

    @PostMapping("/admin/contacts/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return "redirect:/admin/contacts";
    }
}
