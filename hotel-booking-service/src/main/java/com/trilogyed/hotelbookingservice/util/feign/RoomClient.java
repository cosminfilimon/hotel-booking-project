package com.trilogyed.hotelbookingservice.util.feign;

import com.trilogyed.hotelbookingservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "room-service")
@RequestMapping("/room")
public interface RoomClient {

    @GetMapping(value = "/{number}")
    public Room getRoom(@PathVariable int number);

    @GetMapping
    public List<Room> getAllRoom();


}
