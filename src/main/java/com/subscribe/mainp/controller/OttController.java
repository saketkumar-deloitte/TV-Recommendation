package com.subscribe.mainp.controller;

import com.subscribe.mainp.repository.OttRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OttController {

    @Autowired
    OttRepo repo;

    @PostMapping("/upload")
    public String uploadData() throws Exception
    {
        ExcelReadService service = new ExcelReadService();
        repo.saveAll(service.ReadDataFromExcel());
        return "Successfull";
    }

}
