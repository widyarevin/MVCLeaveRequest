package com.proyek.leaverequest.repositories;


import com.proyek.leaverequest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
