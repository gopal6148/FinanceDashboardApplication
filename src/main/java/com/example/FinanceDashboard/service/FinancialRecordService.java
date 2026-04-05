package com.example.FinanceDashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinanceDashboard.entity.FinancialRecord;
import com.example.FinanceDashboard.repository.FinancialRecordRepository;

@Service
public class FinancialRecordService {
	
	@Autowired
    private FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public FinancialRecord update(Long id, FinancialRecord record) {
        FinancialRecord existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setAmount(record.getAmount());
        existing.setCategory(record.getCategory());
        existing.setType(record.getType());
        existing.setDate(record.getDate());
        existing.setNote(record.getNote());

        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
