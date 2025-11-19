 package com.grievance.backend;

import com.grievance.backend.model.Complaint;
import com.grievance.backend.repo.ComplaintRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final ComplaintRepository repo;

    public StartupRunner(ComplaintRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            Complaint c1 = new Complaint();
            c1.setConsumerName("Sam");
            c1.setTitle("Battery overheating");
            c1.setDescription("Phone battery overheats while charging");
            c1.setCompany("Acme Mobile");
            c1.setProduct("Smartphone");
            repo.save(c1);

            Complaint c2 = new Complaint();
            c2.setConsumerName("Ravi");
            c2.setTitle("Late Delivery");
            c2.setDescription("Product arrived 10 days late");
            c2.setCompany("ShopX");
            c2.setProduct("Earphones");
            repo.save(c2);
        }
    }
}
