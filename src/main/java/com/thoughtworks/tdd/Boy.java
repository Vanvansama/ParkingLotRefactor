package com.thoughtworks.tdd;

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
    protected String message;
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    @Override
    public abstract Ticket parkingCar(Car car);

    @Override
    public Car fetchCar(Ticket ticket){
        if (ticket != null) {
            Car car = ticket.getParkingLot().fetchCar(ticket);
            if (car == null) {
                message = "Unrecognized parking ticket.";
            }
            return car;

        } else {
            message = "Please provide your parking ticket.";
            return null;
        }
    }

    public String showMessage() {
        return message;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }
}
