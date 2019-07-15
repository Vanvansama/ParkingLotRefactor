package com.thoughtworks.tdd;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 19:19 2019/7/15
 * @Description:
 */
public interface Parkable {
    Ticket parkingCar(Car car);

    Car fetchCar(Ticket ticket);
}
