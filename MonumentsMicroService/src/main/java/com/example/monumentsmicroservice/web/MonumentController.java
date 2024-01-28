package com.example.monumentsmicroservice.web;

import com.example.monumentsmicroservice.model.Monument;
import com.example.monumentsmicroservice.service.MonumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scratch")
public class MonumentController {
    @Autowired
    private MonumentService monumentService;

    @GetMapping("all")
    public List<Monument> listAll() {
        return monumentService.listAllMonuments();
    }

}
