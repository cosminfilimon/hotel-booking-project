package com.trilogyed.hotelbookingservice.util.feign;

import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;




@FeignClient(name = "rewards-service")
@RequestMapping("/rewards")
public interface RewardsClient {

    @GetMapping(value = "/type/{roomType}")
    public Rewards getRewards(@PathVariable("roomType") String roomType);

    @GetMapping
    public List<Rewards> getAllRewards();


}