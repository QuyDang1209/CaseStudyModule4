package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Performence;
import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;
    @Override
    public Iterable<Player> findAll(){return playerRepository.findAll();}

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        playerRepository.deleteById(id);
    }

    /*
    @Override
    public Iterable<Player> findAllByPerformence(Performence performence) {
        return playerRepository.findAllByPerformence(performence);
    }
    @Override
    public Page<Player> findAllByNameContainging(Pageable pageable, String name) {
        return playerRepository.findAllByNameContainging(pageable, name);
    }

     */

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }
}
