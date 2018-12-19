package com.lpy.springmvc.mapper;

import com.lpy.springmvc.pojo.BaseDict;

import java.util.List;
public interface BaseDictMapper {

    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
