package com.test.easypoi.service;

import com.test.easypoi.pojo.Wheel;

/**
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.service
 * @email williamsang@yeah.net
 * @date: 2019/5/22 16:56
 * @modifyHistory: <br/>
 * --------------<br/>
 */
public interface WheelService {
    int save(Wheel wheel);

    Wheel findByBrand(String brand);

    int update(Wheel wheel);

    int saveOrUpdate(Wheel wheel);
}
