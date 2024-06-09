package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.PlayerTracking;
import org.example.casestudymodule4.model.DTO.PlayerTrackingDTO;
import org.example.casestudymodule4.repository.IPerFormenceRepository;
import org.example.casestudymodule4.repository.IPlayerTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerTrackingService implements IPlayerTrackingService{
    @Autowired
    private IPlayerTrackingRepository playerTrackingRepository;
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private IPerFormenceRepository perFormenceRepository;

    @Override
    public List<PlayerTracking> findAll() {
        return playerTrackingRepository.findAll();
    }

    @Override
    public PlayerTracking findByid(Long id) {
        return playerTrackingRepository.findById(id).get();
    }

    @Override
    public void save(PlayerTracking playerTracking) {
    playerTrackingRepository.save(playerTracking);
    }

    @Override
    public void deleteById(Long id) {

    }




    @Override
    public List<PlayerTracking> findAllByMonthAndYear(Integer month, Integer year) {
        return playerTrackingRepository.findPlayerTrackingByMonthAndYear(month,year);
    }

    @Override
    public List<PlayerTracking> savePlayerTrackingDTO(List<PlayerTrackingDTO> playerTrackingDTO) {
        List<PlayerTracking> playerTrackingList = playerTrackingRepository.findAll();
        for (PlayerTrackingDTO p : playerTrackingDTO){
            PlayerTracking playerTracking = new PlayerTracking();
            playerTracking.setPlayer(playerService.findByid(p.getPlayer()));
            playerTracking.setWeak1(p.getWeak1());
            playerTracking.setWeak2(p.getWeak2());
            playerTracking.setWeak3(p.getWeak3());
            playerTracking.setWeak4(p.getWeak4());
            playerTracking.setMonth(p.getMonth());
            playerTracking.setYear(p.getYear());
            playerTracking.setBonus(p.getBonus());
            playerTracking.setPerformence(perFormenceRepository.findById(p.getPerformence()).get());
            playerTracking.setTotalSalary(playerService.findByid(p.getPlayer()).getSalary()+p.getWeak1()*p.getWeak2()*p.getWeak3()*p.getWeak4()+p.getBonus());
            playerTrackingRepository.save(playerTracking);
            playerTrackingList.add(playerTracking);
        }

        return playerTrackingList;
    }

}
