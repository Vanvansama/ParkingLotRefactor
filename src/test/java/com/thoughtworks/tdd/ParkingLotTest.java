package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.Exception.PleaseProvideYourParkingTicketException;
import com.thoughtworks.tdd.Exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 10:50 2019/7/14
 * @Description:
 */
public class ParkingLotTest {

    private ParkingLot parkingLot = new ParkingLot();
    private ParkingLot parkingLotTwo = new ParkingLot();

    private ParkingBoy parkingBoy = new ParkingBoy();
    private SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    private SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
    private ParkingLotManage manage = new ParkingLotManage();

    @Test
    public void should_return_car_when_fetch_car_given_tickets() {
        //given
        Car car = new Car("BMW", "123456");
        parkingBoy.setParkingLot(parkingLot);
        parkingBoy.setParkingLot(parkingLotTwo);
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(car, fetchCar);
    }

    @Test
    public void should_return_tickets_when_paring_car_given_cars() {
        //given
        Car car = new Car("BMW", "123456");
        Car car1 = new Car("BMW", "7891011");
        Car car2 = new Car("Mercedes", "123456");
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.parkingCar(car);
        Ticket ticket1 = parkingBoy.parkingCar(car1);
        Ticket ticket2 = parkingBoy.parkingCar(car2);
        //when
        Car fetchCar = parkingBoy.fetchCar(ticket);
        Car fetchCar1 = parkingBoy.fetchCar(ticket1);
        Car fetchCar2 = parkingBoy.fetchCar(ticket2);
        //then
        Assertions.assertSame(car, fetchCar);
        Assertions.assertSame(car1, fetchCar1);
        Assertions.assertSame(car2, fetchCar2);
    }

    @Test
    public void should_return_null_when_fetch_car_given_wrong_ticket() {
        Assertions.assertThrows(PleaseProvideYourParkingTicketException.class, () -> parkingBoy.fetchCar(null));
    }

    @Test
    public void should_return_null_when_fetch_car_given_used_tickets() {
        //given
        Car car = new Car("BMW", "123456");
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetchCar(ticket));
    }

    @Test
    public void should_return_null_when_no_place_given_car() {
        //given
        parkingBoy.setParkingLot(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car("BMW", "" + i);
            parkingBoy.parkingCar(car);
        }
        //when
        Car car = new Car("BMW", "123456");
        Assertions.assertThrows(NotEnoughPositionException.class, () -> parkingBoy.parkingCar(car));
    }

    @Test
    public void should_parking_car_to_next_parkingLot_when_first_parkingLot_no_place_given_car() {
        //given
        parkingBoy.setParkingLot(parkingLot);
        parkingBoy.setParkingLot(parkingLotTwo);
        for (int i = 0; i < 10; i++) {
            Car car = new Car("BMW", "" + i);
            parkingBoy.parkingCar(car);
        }
        Car car = new Car("BMW", "123456");
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(car, fetchCar);
    }

    @Test
    public void should_return_ticket__when_smart_parkingBoy_given_car() {
        //given
        smartParkingBoy.setParkingLot(parkingLot);
        smartParkingBoy.setParkingLot(parkingLotTwo);
        for (int i = 0; i < 3; i++) {
            Car car = new Car("BMW", "" + i);
            smartParkingBoy.parkingCar(car);
        }
        Car car = new Car("BMW", "123456");
        Ticket ticket = smartParkingBoy.parkingCar(car);
        //when
        Car fetchCar = smartParkingBoy.fetchCar(ticket);
        ParkingLot parkingLotActual = ticket.getParkingLot();
        //then
        Assertions.assertSame(car, fetchCar);
        Assertions.assertSame(parkingLotTwo, parkingLotActual);
    }

    @Test
    public void should_return_ticket_when_super_smart_parkingBoy_given_car() {
        //given
        superSmartParkingBoy.setParkingLot(parkingLot);
        superSmartParkingBoy.setParkingLot(parkingLotTwo);
        for (int i = 0; i < 3; i++) {
            Car car = new Car("BMW", "" + i);
            superSmartParkingBoy.parkingCar(car);
        }
        Car car = new Car("BMW", "123456");
        Ticket ticket = superSmartParkingBoy.parkingCar(car);
        //when
        Car fetchCar = superSmartParkingBoy.fetchCar(ticket);
        ParkingLot parkingLotActual = ticket.getParkingLot();
        //then
        Assertions.assertSame(car, fetchCar);
        Assertions.assertSame(parkingLotTwo, parkingLotActual);
    }

    @Test
    public void should_return_car_when_manage_specify_parkingBoy_given_car() {
        //given
        manage.setParkables(smartParkingBoy);
        smartParkingBoy.setParkingLot(parkingLot);
        Car car = new Car("BMW", "123456");
        Ticket ticket = manage.parkingCar(car);
        //when
        Car fetchCar = superSmartParkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(car, fetchCar);
    }

    @Test
    public void should_return_car_when_manage_given_car() {
        //given
        manage.setParkables(parkingLot);
        Car car = new Car("BMW", "123456");
        Ticket ticket = manage.parkingCar(car);
        //when
        Car fetchCar = manage.fetchCar(ticket);
        //then
        Assertions.assertSame(car, fetchCar);
    }

    @Test
    public void should_return_null_when_manage_fetch_car_given_wrong_ticket() {
        manage.setParkables(smartParkingBoy);
        smartParkingBoy.setParkingLot(parkingLot);

        Assertions.assertThrows(PleaseProvideYourParkingTicketException.class, () -> manage.fetchCar(null));
    }

    @Test
    public void should_return_null_when_manage_fetch_car_given_used_tickets() {
        //given
        manage.setParkables(smartParkingBoy);
        smartParkingBoy.setParkingLot(parkingLot);
        Car car = new Car("BMW", "123456");
        Ticket ticket = manage.parkingCar(car);
        //when
        manage.fetchCar(ticket);
        Assertions.assertThrows(UnrecognizedParkingTicketException.class,()->manage.fetchCar(ticket));
    }


}
