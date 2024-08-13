package com.organization.organization_management.controller;

import com.organization.organization_management.model.Slab;
import com.organization.organization_management.service.SlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slab")
public class SlabController {

    @Autowired
    SlabService service;
    @PostMapping("/add")
    public Slab addSlabLayer(@RequestBody Slab slab) {
        return service.addSlab(slab);
    }

    @PutMapping("/update")
    public Slab updateSlabLayer(@RequestBody Slab slab) {
        return service.updateSlab(slab);
    }
}
