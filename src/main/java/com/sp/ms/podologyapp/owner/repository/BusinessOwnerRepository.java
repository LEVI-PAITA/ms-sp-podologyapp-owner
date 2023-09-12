package com.sp.ms.podologyapp.owner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;

@Repository
public interface BusinessOwnerRepository extends JpaRepository<BusinessOwner, Long>{

}
