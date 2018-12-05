package com.lpy.spring;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelloDao6 {
    private String[] nameArr;
    private List<String> nameList;
    private Set<String> nameSet;
    private Map<String, String> nameMap;

    public String[] getNameArr() {
        return nameArr;
    }

    public void setNameArr(String[] nameArr) {
        this.nameArr = nameArr;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public Set<String> getNameSet() {
        return nameSet;
    }

    public void setNameSet(Set<String> nameSet) {
        this.nameSet = nameSet;
    }

    public Map<String, String> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }

    @Override
    public String toString() {
        return "HelloDao6{" +
                "nameArr=" + Arrays.toString(nameArr) +
                ", nameList=" + nameList +
                ", nameSet=" + nameSet +
                ", nameMap=" + nameMap +
                '}';
    }
}
