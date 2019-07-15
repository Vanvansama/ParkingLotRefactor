package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPositionException;

import java.util.Comparator;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 17:36 2019/7/14
 * @Description:
 */
public class SuperSmartParkingBoy extends Boy {

    @Override
    public Ticket parkingCar(Car car) {
        if (car != null) {
            ParkingLot parkingLot = parkingLotList.stream().max(Comparator.comparingDouble(ParkingLot::getAvailablePositionRate)).orElse(null);
            if (parkingLot == null){
                throw new NotEnoughPositionException();
            }
            return  parkingLot.parkingCar(car);
        }
        return null;
    }
}
