package com.test.easypoi.service.impl;

import com.test.easypoi.mapper.LoanMapper;
import com.test.easypoi.service.ILoanService;
import com.test.easypoi.util.entity.excel.LoanExcelBean;
import com.test.easypoi.util.entity.generic.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 标的service 实现
 *
 * @author WilliamSang
 * @date 2018/11/13 16:12
 */
@Service
public class LoanServiceImpl implements ILoanService {
    @Autowired
    LoanMapper loanMapper;

    @Override
    public List<LoanExcelBean> findLoanExcel(Date finalDate) {
        return loanMapper.findLoanExcelWithLongestDate(finalDate);
    }

    @Override
    public List<Map<String, Object>> findGenericExcel(Collection<String[]> values, String paramStr) {
        List<String> list = new ArrayList<>();
        for (String[] arg :
                values) {
            String safeFirstString = CommonUtil.getSafeFirstString(arg);
            if (safeFirstString != null) {
                list.add(safeFirstString);
            }
        }

        return loanMapper.findGenericExcelData(paramStr, list);
    }
}
