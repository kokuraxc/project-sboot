package com.zhengjin.guo.projectsboot.data.repository;

import com.zhengjin.guo.projectsboot.data.entity.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    
}
