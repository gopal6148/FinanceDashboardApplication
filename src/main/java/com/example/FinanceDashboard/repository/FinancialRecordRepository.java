package com.example.FinanceDashboard.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FinanceDashboard.entity.FinancialRecord;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long>{
	List<FinancialRecord> findByType(String type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);

}
