 package com.grievance.backend.repo;

import com.grievance.backend.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // add custom queries later (findByCompany, findByStatus, etc.)
}
