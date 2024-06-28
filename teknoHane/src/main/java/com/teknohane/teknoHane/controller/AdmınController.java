package com.teknohane.teknoHane.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/fero")
public class AdmınController {

    @GetMapping("get")
    @PreAuthorize("hasRole('ADMIN')")
    public String getName(){
        return "Ferhat Ürper";
    }
}
