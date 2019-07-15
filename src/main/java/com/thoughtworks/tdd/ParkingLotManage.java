package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 18:07 2019/7/14
 * @Description:
 */
public class ParkingLotManage{
    private List<Parkable> parkables = new ArrayList<>();

    public Ticket parkingCar(Car car){
        for (Parkable parkable : parkables) {
            Ticket ticket = parkable.parkingCar(car);
            if (ticket != null ){
                return ticket;
            }
        }
        return null;
    }

    public Car fetchCar(Ticket ticket){
        for (Parkable parkable : parkables) {
            Car car = parkable.fetchCar(ticket);
            if (car != null ){
                return car;
            }
        }
        return null;
    }

    public void setParkables(Parkable parkable){
        parkables.add(parkable);
    }
}
