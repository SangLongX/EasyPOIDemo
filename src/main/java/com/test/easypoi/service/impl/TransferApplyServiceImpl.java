package com.test.easypoi.service.impl;

import com.test.easypoi.mapper.TransferApplyMapper;
import com.test.easypoi.service.ITransferApplyService;
import com.test.easypoi.util.entity.excel.TransferApplyExcelBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 债转service 实现
 *
 * @author WilliamSang
 * @date 2018/11/13 16:14
 */
@Service
public class TransferApplyServiceImpl implements ITransferApplyService {
    @Autowired
    TransferApplyMapper transferApplyMapper;

    private String [] symbols = {",", "，"};

    @Override
    public List<TransferApplyExcelBean> findTransferApplyExcel(String toWhere, Date transferApplyStartTime, String userIds) {
        List<String> userIdList = null;
        if (StringUtils.isNotBlank(userIds)) {
            if (userIds.contains(symbols[0])) {
                userIdList = Arrays.asList(userIds.split(symbols[0]));
            } else if (userIds.contains(symbols[1])) {
                userIdList = Arrays.asList(userIds.split(symbols[1]));
            } else {
                userIdList = new ArrayList<>();
                userIdList.add(userIds);
            }
        }

        return transferApplyMapper.findTransferApplyExcelWithItems(toWhere, transferApplyStartTime, userIdList != null ? userIdList.toArray(new String[]{}) : null);
    }
}
