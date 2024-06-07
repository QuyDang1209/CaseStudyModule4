package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.model.dto.PlayerDTO;
import org.example.casestudymodule4.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Value("${upload.path}")
    private String upload;
    @Autowired
    IPlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findByid(Long id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public void save(Player player) {
    playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player savePlayerDTO(PlayerDTO playerDTO) {
        MultipartFile multipartFile = playerDTO.getImg();
        String urlImage = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(playerDTO.getImg().getBytes(), new File(upload, urlImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Player player = null;
        if (playerDTO.getId() == null) {
            player = new Player();
        }else{
            player = playerRepository.findById(playerDTO.getId()).get();
        }
        player.setCode(playerDTO.getCode());
        player.setName(playerDTO.getName());
        player.setDob(playerDTO.getDob());
        player.setAddress(playerDTO.getAddress());
        player.setPosition(playerDTO.getPosition());
        player.setPer(playerDTO.getPer());
        player.setHeight(playerDTO.getHeight());
        player.setWeight(playerDTO.getWeight());
        player.setSalary(playerDTO.getSalary());
        player.setRanking(playerDTO.getRanking());
        player.setImg(urlImage);
        player.setStatus(playerDTO.getStatus());

        playerRepository.save(player);
        return player ;
    }
}
