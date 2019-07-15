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
            ParkingLot parkingLotActual = parkingLotList.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().orElse(null);
            if (parkingLotActual == null){
                throw new NotEnoughPositionException();
            }
            return  parkingLotActual.parkingCar(car);
        }
        return null;
    }

}
