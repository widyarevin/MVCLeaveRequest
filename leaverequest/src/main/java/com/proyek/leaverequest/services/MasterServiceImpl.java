package com.proyek.leaverequest.services;

import com.proyek.leaverequest.entities.Master;
import com.proyek.leaverequest.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterRepository masterRepository;

    @Override
    public List<Master> findAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public boolean saveMaster(Master master) {
        masterRepository.save(master);
        return masterRepository.findById(master.getId()).isPresent();
    }

    @Override
    public Master findMasterById(int id) {
        return masterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Master tidak ditemukan"));
    }

    @Override
    public boolean deleteMasterById(int id) {
        masterRepository.deleteById(id);
        return !masterRepository.findById(id).isPresent();
    }
}
