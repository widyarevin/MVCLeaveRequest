package com.proyek.leaverequest.services;

import com.proyek.leaverequest.entities.Master;
import com.proyek.leaverequest.entities.User;
import com.proyek.leaverequest.repositories.MasterRepository;
import com.proyek.leaverequest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Master> findAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public boolean saveMaster(Master master) {
        master.setStatus("Waiting");
//        master.setSubmitDate();
        User user = userRepository.findById(master.getId()).get();
//        user.getTotalLeave()=
        userRepository.save(user);
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

    @Override
    public boolean approval(int id) {
        // cari data by id
        Master master = masterRepository.findById(id).get();
        // ganti data yang dibutuhkan
        master.setStatus("Approve");
//        master.setApprovalDate();
        // di save
         masterRepository.save(master);
        return !masterRepository.findById(id).isPresent();
    }

    @Override
    public boolean reject(int id) {
        // cari data by id
        Master master = masterRepository.findById(id).get();
        // ganti data yang dibutuhkan
        master.setStatus("Rejected");
        // di save
        masterRepository.save(master);
        return !masterRepository.findById(id).isPresent();
    }
}
