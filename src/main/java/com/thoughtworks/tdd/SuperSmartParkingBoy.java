package com.thoughtworks.tdd;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 17:36 2019/7/14
 * @Description:
 */
public class SuperSmartParkingBoy extends Boy {
    @Override
    Ticket parkingCar(Car car) {
        if (car != null) {
            Ticket ticket = null;
            float temp = 0;
            int index = -1;
            for (int i = 0; i < parkingLotList.size(); i++) {
                ParkingLot parkingLot = parkingLotList.get(i);
                float available = parkingLot.positionsAvailable();
                float lotSize = parkingLot.getParkingLotSize();
                float size = available / lotSize;
                if (size > temp) {
                    temp = size;
                    index = i;
                }
            }
            if (temp > 0) {
                ParkingLot parkingLot = parkingLotList.get(index);
                ticket = parkingLot.parkingCar(car);
            } else {
                message = "Not enough position.";
            }
            return ticket;
        }
        return null;
    }
}
