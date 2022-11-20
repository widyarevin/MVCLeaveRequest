package com.proyek.leaverequest.repositories;

import com.proyek.leaverequest.entities.Category;
import com.proyek.leaverequest.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master, Integer> {
}

