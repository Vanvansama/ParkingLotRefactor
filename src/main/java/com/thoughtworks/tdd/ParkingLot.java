package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.Exception.UnrecognizedParkingTicketException;

import java.util.*;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 11:33 2019/7/14
 * @Description:
 */
public class ParkingLot implements Parkable{
    private final static int CAR_NUMBER = 10;
    private Map<Ticket, Car> carList = new HashMap<>(CAR_NUMBER);
    private ParkingLotManage manage;

    @Override
    public Ticket parkingCar(Car car) {
        if (carList.size() < CAR_NUMBER) {
            Ticket ticket = new Ticket(car, this);
            carList.put(ticket, car);
            return ticket;
        }else {
            throw new NotEnoughPositionException();
        }
    }

    @Override
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

    public double getAvailablePositionRate(){
        return (double)positionsAvailable()/(double)getParkingLotSize();
    }

    public void setManage(ParkingLotManage manage) {
        this.manage = manage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(carList, that.carList) &&
                Objects.equals(manage, that.manage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList, manage);
    }
}
