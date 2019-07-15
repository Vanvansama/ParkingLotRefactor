package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.PleaseProvideYourParkingTicketException;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 17:30 2019/7/14
 * @Description:
 */
public abstract class Boy implements Parkable{
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    @Override
    public abstract Ticket parkingCar(Car car);

    @Override
    public Car fetchCar(Ticket ticket){
        if (ticket != null) {
            return ticket.getParkingLot().fetchCar(ticket);

        } else {
            throw new PleaseProvideYourParkingTicketException();
        }
    }

    public void setParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }
}
