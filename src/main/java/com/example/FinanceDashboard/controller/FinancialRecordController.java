package com.example.FinanceDashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinanceDashboard.entity.FinancialRecord;
import com.example.FinanceDashboard.service.FinancialRecordService;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {
	 @Autowired
	    private FinancialRecordService service;

	    @PostMapping
	    public FinancialRecord create(@RequestBody FinancialRecord record) {
	        return service.create(record);
	    }

	    @GetMapping
	    public List<FinancialRecord> getAll() {
	        return service.getAll();
	    }

	    @PutMapping("/{id}")
	    public FinancialRecord update(@PathVariable Long id,
	                                 @RequestBody FinancialRecord record) {
	        return service.update(id, record);
	    }

	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Long id) {
	        service.delete(id);
	        return "Deleted successfully";
	    }

}
