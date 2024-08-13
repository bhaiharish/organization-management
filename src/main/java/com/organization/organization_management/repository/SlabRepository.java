package com.organization.organization_management.repository;

import com.organization.organization_management.model.Slab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlabRepository extends JpaRepository<Slab,String> {
    @Query("SELECT e FROM Slab e WHERE e.title =?1")
    List<Slab> findByTitle(String title);
}
