package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 16:48 2019/7/14
 * @Description:
 */
public class SmartParkingBoy extends Boy {

    @Override
    public Ticket parkingCar(Car car) {
        if (car != null) {
            Ticket ticket = null;
            int temp = 0, index = -1;
            for (int i = 0; i < parkingLotList.size(); i++) {
                ParkingLot parkingLot = parkingLotList.get(i);
                if ( parkingLot.positionsAvailable() > temp ){
                    temp = parkingLot.positionsAvailable();
                    index = i;
                }
            }
            if (temp>0){
                ParkingLot parkingLot = parkingLotList.get(index);
                ticket = parkingLot.parkingCar(car);
            }else{
                message = "Not enough position.";
            }
            return ticket;
        }
        return null;
    }

}
