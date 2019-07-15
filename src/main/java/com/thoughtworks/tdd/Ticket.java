package com.thoughtworks.tdd;

import java.util.Objects;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 11:11 2019/7/14
 * @Description:
 */
public class Ticket {
    private Car car;
    private ParkingLot parkingLot;

    public Ticket(Car car, ParkingLot parkingLot) {
        this.car = car;
        this.parkingLot = parkingLot;
    }

    public Car fecthCar() {
        return car;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return Objects.equals(car, ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}
