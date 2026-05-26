package com.avaneesh.bfhl_java_assignment.controller;

import com.avaneesh.bfhl_java_assignment.dto.BfhlRequest;
import com.avaneesh.bfhl_java_assignment.dto.BfhlResponse;
import com.avaneesh.bfhl_java_assignment.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @PostMapping
    public BfhlResponse processData(
            @RequestBody BfhlRequest request
    ) {

        return bfhlService.processData(request);
    }
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}