package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.service.TripService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(TripService.class)
public class TripServiceTest {

    @MockBean
    private TripRepository tripRepository;

    @Autowired
    private TripService tripService;

    @Test
    public void whenFindAll_thenReturnAllTrips() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        List<TripDto> allTrips = Collections.singletonList(tripDto);
        given(tripRepository.findAll()).willReturn(allTrips);

        Assert.assertEquals(tripService.findAll(), allTrips);
    }

    @Test
    public void whenFindById_thenReturnTrip() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        given(tripRepository.findById(1L)).willReturn(tripDto);

        Assert.assertEquals(tripService.findById(1L), tripDto);
    }

    @Test
    public void whenDeleteById_thenDeleteTrip() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        given(tripRepository.findById(1L)).willReturn(tripDto);

        Assert.assertEquals(tripRepository.findById(1L), tripDto);

        tripService.delete(1L);

        given(tripRepository.findById(1L)).willReturn(null);

        Assert.assertNull(tripRepository.findById(1L));

    }

    @Test
    public void whenSave_thenCreateTrip() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        given(tripRepository.findById(1L)).willReturn(null);

        Assert.assertNull(tripRepository.findById(1L));

        tripService.save(tripDto);

        given(tripRepository.findById(1L)).willReturn(tripDto);

        Assert.assertEquals(tripRepository.findById(1L), tripDto);
    }

    @Test
    public void whenUpdate_thenUpdateTrip() {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        given(tripRepository.findById(1L)).willReturn(tripDto);

        Assert.assertEquals(tripRepository.findById(1L), tripDto);

        tripDto.setOrigin("SPB");

        tripService.update(tripDto);

        given(tripRepository.findById(1L)).willReturn(tripDto);

        Assert.assertEquals(tripRepository.findById(1L), tripDto);

    }
}
