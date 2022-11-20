package com.proyek.leaverequest.services;

import com.proyek.leaverequest.entities.Master;

import java.util.List;

public interface MasterService {
    public List<Master> findAllMasters();
    public boolean saveMaster(Master master);
    public Master findMasterById(int id);
    public boolean deleteMasterById(int id);
}
