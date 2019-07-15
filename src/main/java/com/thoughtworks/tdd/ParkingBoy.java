package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPositionException;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 11:11 2019/7/14
 * @Description:
 */
public class ParkingBoy extends Boy{

    @Override
    public Ticket parkingCar(Car car) {
        if (car != null) {
            Ticket ticket = null;
            for (ParkingLot parkingLot : parkingLotList) {
                ticket = parkingLot.parkingCar(car);
                if (ticket != null) {
                    break;
                }
            }
            if (ticket == null) {
                throw new NotEnoughPositionException();
            }
            return ticket;
        }
        return null;
    }

}
