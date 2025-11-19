 package com.grievance.backend.service;

import com.grievance.backend.model.Complaint;
import com.grievance.backend.repo.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    private final ComplaintRepository repo;

    public ComplaintService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public List<Complaint> listAll() {
        return repo.findAll();
    }

    public Complaint create(Complaint c) {
        c.setCreatedAt(LocalDateTime.now());
        if (c.getStatus() == null) c.setStatus("OPEN");
        return repo.save(c);
    }

    public Optional<Complaint> get(Long id) {
        return repo.findById(id);
    }

    public Complaint update(Long id, Complaint incoming) {
        return repo.findById(id).map(existing -> {
            existing.setConsumerName(incoming.getConsumerName());
            existing.setTitle(incoming.getTitle());
            existing.setDescription(incoming.getDescription());
            existing.setProduct(incoming.getProduct());
            existing.setCompany(incoming.getCompany());
            existing.setStatus(incoming.getStatus());
            existing.setUpdatedAt(LocalDateTime.now());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Complaint not found: " + id));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
