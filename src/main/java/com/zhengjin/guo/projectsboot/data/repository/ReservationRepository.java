package com.zhengjin.guo.projectsboot.data.repository;

import com.zhengjin.guo.projectsboot.data.entity.Reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
