package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Status;
import org.example.casestudymodule4.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusService implements IStatusService {

    @Autowired
    private IStatusRepository iStatusRepository;

    @Override
    public Iterable<Status> findAll() {
        return iStatusRepository.findAll();
    }

    @Override
    public void save(Status status) {
        iStatusRepository.save(status);
    }

    @Override
    public Optional<Status> findById(Long id) {
        return iStatusRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iStatusRepository.deleteById(id);
    }
}
