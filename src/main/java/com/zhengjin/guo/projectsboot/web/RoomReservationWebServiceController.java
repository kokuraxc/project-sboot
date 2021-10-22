package com.zhengjin.guo.projectsboot.web;

import java.util.Date;
import java.util.List;

import com.zhengjin.guo.projectsboot.business.domain.RoomReservation;
import com.zhengjin.guo.projectsboot.business.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roomreservations")
public class RoomReservationWebServiceController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false) String dateString) {
        Date date = DateUtils.createDateFromString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }
}
