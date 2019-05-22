package com.test.easypoi.service.impl;

import com.test.easypoi.mapper.WheelMapper;
import com.test.easypoi.pojo.Wheel;
import com.test.easypoi.service.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.service.impl
 * @email williamsang@yeah.net
 * @date: 2019/5/22 16:56
 * @modifyHistory: <br/>
 * --------------<br/>
 */
@Service
public class WheelServiceImpl implements WheelService {
    @Autowired
    private WheelMapper wheelMapper;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int save(Wheel wheel) {
        return wheelMapper.insertSelective(wheel);
    }

    @Override
    public Wheel findByBrand(String brand) {
        return wheelMapper.selectByPrimaryKey(brand);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int update(Wheel wheel) {
        return wheelMapper.updateByPrimaryKeySelective(wheel);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int saveOrUpdate(Wheel wheel) {
        Wheel byBrand = findByBrand(wheel.getBrand());
        if (byBrand == null) {
            return save(wheel);
        } else {
            return update(wheel);
        }
    }
}
