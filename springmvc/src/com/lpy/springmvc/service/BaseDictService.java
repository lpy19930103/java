package com.lpy.springmvc.service;

import java.util.List;
import com.lpy.springmvc.pojo.BaseDict;
import org.springframework.stereotype.Service;

public interface BaseDictService{
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
