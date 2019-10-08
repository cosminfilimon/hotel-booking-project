package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelRewards")
public class BookingController {
    @Autowired
     private BookingService bookingService;

    @GetMapping("/{roomId}")
    public BookingViewModel createBooking(@PathVariable("roomId") Integer roomNumber,
                                          @RequestParam(value = "rewardsMember", defaultValue = "false", required = false) boolean rewardsMember ,
                                          @RequestParam(value = "doubleBonusDay", defaultValue = "false",required = false) boolean doubleBonusDay) {
        BookingViewModel bookingViewModel = new BookingViewModel();
       bookingViewModel.setRewardsMember(rewardsMember);
       bookingViewModel.setDoubleBonusDay(doubleBonusDay);
       bookingViewModel.setRoomNumber(roomNumber);
    return bookingService.calculateBooking(bookingViewModel);
    }

    @GetMapping("/booking/rooms")
    public List<Room> getAllRooms(){
        return bookingService.getAllRooms();
    }
    @GetMapping("/booking/rewards")
    public List<Rewards> getAllRewards(){
        return bookingService.getAllRewards();
    }
}
