package com.lpy.springmvc.service.impl;

import com.lpy.springmvc.mapper.BaseDictMapper;
import com.lpy.springmvc.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.lpy.springmvc.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService{

    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String code) {
        return baseDictMapper.queryBaseDictByDictTypeCode(code);
    }
}
