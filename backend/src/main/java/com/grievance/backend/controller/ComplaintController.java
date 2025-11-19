 package com.grievance.backend.controller;

import com.grievance.backend.model.Complaint;
import com.grievance.backend.service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/api/complaints", "/complaints"})
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<Complaint> getAll() {
        return service.listAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getById(@PathVariable Long id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Complaint> create(@RequestBody Complaint complaint) {
        Complaint saved = service.create(complaint);
        return ResponseEntity.created(
                URI.create("/api/complaints/" + saved.getId())
        ).body(saved);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> update(
            @PathVariable Long id,
            @RequestBody Complaint incoming
    ) {
        try {
            Complaint updated = service.update(id, incoming);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
