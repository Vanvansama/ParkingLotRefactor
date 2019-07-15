package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 18:07 2019/7/14
 * @Description:
 */
public class ParkingLotManage extends ParkingBoy {
    private List<Boy> parkingBoyList = new ArrayList<>();

    public void addParkingBoy(Boy boy){
        parkingBoyList.add(boy);
    }

    public List<Boy> getParkingBoyList() {
        return parkingBoyList;
    }
}
