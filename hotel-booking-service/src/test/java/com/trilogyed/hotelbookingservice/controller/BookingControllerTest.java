package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.model.BookingViewModel;
import com.trilogyed.hotelbookingservice.service.BookingService;
import feign.form.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BookingControllerTest {


    @MockBean
    private BookingService bookingService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void createBooking() throws Exception{

        BookingViewModel bvm = new BookingViewModel();
        bvm.setRoomNumber(101);
        bvm.setRewardsMember(true);
        bvm.setDoubleBonusDay(true);

        BookingViewModel bvm2 = new BookingViewModel();
        bvm2.setRoomNumber(101);
        bvm2.setFinalCost(50.00f);
        bvm2.setRewardsMember(true);
        bvm2.setDoubleBonusDay(true);

        doReturn(bvm2).when(bookingService).calculateBooking(bvm);
        mockMvc.perform(MockMvcRequestBuilders
        .get("/hotelRewards/101?rewardsMember=true&doubleBonusDay=true")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalCost").value(50.00f));


    }
}