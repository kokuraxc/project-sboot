package com.zhengjin.guo.projectsboot.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhengjin.guo.projectsboot.business.domain.RoomReservation;
import com.zhengjin.guo.projectsboot.data.entity.Guest;
import com.zhengjin.guo.projectsboot.data.entity.Reservation;
import com.zhengjin.guo.projectsboot.data.entity.Room;
import com.zhengjin.guo.projectsboot.data.repository.GuestRepository;
import com.zhengjin.guo.projectsboot.data.repository.ReservationRepository;
import com.zhengjin.guo.projectsboot.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
            ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Reservation> reservations = this.reservationRepository
                .findReservationByDate(new java.sql.Date(date.getTime()));

        List<RoomReservation> roomReservations = new ArrayList<>();

        reservations.forEach(reservation -> {
            RoomReservation roomReservation = new RoomReservation();

            roomReservation.setDate(new java.sql.Date(date.getTime()));

            // get room
            Room room = this.roomRepository.findById(reservation.getRoomId()).get();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());

            // get guest
            Guest guest = this.guestRepository.findById((reservation.getGuestId())).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());

            roomReservations.add(roomReservation);
        });

        return roomReservations;
    }
}
