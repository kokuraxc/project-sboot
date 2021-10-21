package com.zhengjin.guo.projectsboot.data.repository;

import com.zhengjin.guo.projectsboot.data.entity.Guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
