package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingService {

    @Autowired
    private RewardsClient rewardsClient;

    @Autowired
    private RoomClient roomClient;


    public void calculateDoubleBonus(BookingViewModel bookingViewModel, Rewards rewards){
        if(bookingViewModel.getRoomType().equals(rewards.getRoomType())
                && bookingViewModel.getDoubleBonusDay()
                && rewards.getCanDouble()){
            bookingViewModel.setTotalRewardsPoints(new Integer(rewards.getPoints().intValue() * 2));
        }
    }

    public BookingViewModel calculateBooking(BookingViewModel bookingViewModel){
        if(bookingViewModel.getRewardsMember().equals(false)){
            bookingViewModel.setTotalRewardsPoints(0);
        }else{
            Room room = roomClient.getRoom(bookingViewModel.getRoomNumber());
            bookingViewModel.setRoomType(room.getRoomType());
            bookingViewModel.setBaseRate(room.getBaseRate());
            Rewards rewards = rewardsClient.getRewards(room.getRoomType());
            bookingViewModel.setCanDouble(rewards.getCanDouble());
            bookingViewModel.setMemberDiscount(rewards.getDiscount());
            bookingViewModel.setBaseRewardsPoints(rewards.getPoints());
            if (isDiscountEligible(room, rewards)) {
                bookingViewModel.setFinalCost(new Float(room.getBaseRate() * (1 - rewards.getDiscount().floatValue())));
            }
            else {
                bookingViewModel.setFinalCost(room.getBaseRate());
            }calculateDoubleBonus(bookingViewModel,rewards);

        }
        return bookingViewModel;
    }

    public boolean isRewardMember(BookingViewModel bookingViewModel){

        return bookingViewModel.getRewardsMember();
    }

    public boolean isDiscountEligible(Room room, Rewards rewards){
        return (room.getRoomType().equals(rewards.getRoomType()) && rewards.getDiscount().floatValue() > 0);
    }

    public boolean isDoubleBonusDay(BookingViewModel bookingViewModel){
        return bookingViewModel.getDoubleBonusDay();
    }

    public boolean isRewardsDouble(BookingViewModel bookingViewModel, Room room, Rewards rewards){
        if(bookingViewModel.getRoomType().equals(rewards.getRoomType())
                && bookingViewModel.getRoomType().equals(room.getRoomType())){
            bookingViewModel.setCanDouble(rewards.getCanDouble());
        }
        return rewards.getCanDouble();
    }


    public List<Room> getAllRooms() {

        return roomClient.getAllRoom();
    }

    public List<Rewards> getAllRewards() {
        return rewardsClient.getAllRewards();
    }
}
