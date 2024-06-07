package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Coach;
import org.example.casestudymodule4.model.dto.CoachDTO;
import org.example.casestudymodule4.repository.ICoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class CoachService implements ICoachService {
    @Value("${upload.path}")
    private String upload;
    @Autowired
    private ICoachRepository coachRepository;
    @Override
    public Iterable<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Optional<Coach> findById(Long id) {
        return coachRepository.findById(id);
    }

    @Override
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public void remove(Long id) {
        coachRepository.deleteById(id);
    }


    @Override
    public Coach saveCoachDTO(CoachDTO coachDTO) {
        // save Multipart de lay urlImage
        MultipartFile multipartFile = coachDTO.getImg();
        String urlImage = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(coachDTO.getImg().getBytes(), new File(upload, urlImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // chuyen doi ComputerDTO -> Computer
        Coach coach = new Coach();
        coach.setCode(coachDTO.getCode());
        coach.setName(coachDTO.getName());
        coach.setDob(coachDTO.getDob());
        coach.setAddress(coachDTO.getAddress());
        coach.setSalary(coachDTO.getSalary());

        // gan urlImage vao Computer
        coach.setImg(urlImage);
        coachRepository.save(coach);

        return coach;
    }
}