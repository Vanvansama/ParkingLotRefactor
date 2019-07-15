package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.Exception.UnrecognizedParkingTicketException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 11:33 2019/7/14
 * @Description:
 */
public class ParkingLot {
    private final static int CAR_NUMBER = 10;
    private Map<Ticket, Car> carList = new HashMap<>(CAR_NUMBER);
    private ParkingLotManage manage;

    public Ticket parkingCar(Car car) {
        if (carList.size() < CAR_NUMBER) {
            Ticket ticket = new Ticket(car, this);
            carList.put(ticket, car);
            return ticket;
        }else {
            throw new NotEnoughPositionException();
        }
    }

    public Car fetchCar(Ticket ticket) {
        if (carList.containsKey(ticket)) {
            Car car = carList.get(ticket);
            carList.remove(ticket);
            return car;
        }else {
            throw new UnrecognizedParkingTicketException();
        }
    }

    public boolean isFull(){
        return carList.size() >= CAR_NUMBER;
    }

    public int positionsAvailable() {
        return CAR_NUMBER - carList.size();
    }

    public int getParkingLotSize(){
        return CAR_NUMBER;
    }

    public void setManage(ParkingLotManage manage) {
        this.manage = manage;
    }
}
