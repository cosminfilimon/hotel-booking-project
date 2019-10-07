package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

    @Autowired
    private RewardsClient rewardsClient;

    @Autowired
    private RoomClient roomClient;


    public BookingViewModel calculateBooking(BookingViewModel bookingViewModel){

        return null;
    }

}
