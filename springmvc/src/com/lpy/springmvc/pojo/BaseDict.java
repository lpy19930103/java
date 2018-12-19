
package com.lpy.springmvc.pojo;


public class BaseDict {

    /**
     * dict_type_name : 客户行业
     * dict_id : 1
     * dict_sort : 1
     * dict_enable : 1
     * dict_type_code : 001
     * dict_memo : null
     * dict_item_name : 教育培训
     * dict_item_code : null
     */
    private String dict_type_name;
    private String dict_id;
    private int dict_sort;
    private String dict_enable;
    private String dict_type_code;
    private String dict_memo;
    private String dict_item_name;
    private String dict_item_code;





    public void setDict_type_name(String dict_type_name) {
        this.dict_type_name = dict_type_name;
    }

    public void setDict_id(String dict_id) {
        this.dict_id = dict_id;
    }

    public void setDict_sort(int dict_sort) {
        this.dict_sort = dict_sort;
    }

    public void setDict_enable(String dict_enable) {
        this.dict_enable = dict_enable;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }

    public void setDict_memo(String dict_memo) {
        this.dict_memo = dict_memo;
    }

    public void setDict_item_name(String dict_item_name) {
        this.dict_item_name = dict_item_name;
    }

    public void setDict_item_code(String dict_item_code) {
        this.dict_item_code = dict_item_code;
    }

    public String getDict_type_name() {
        return dict_type_name;
    }

    public String getDict_id() {
        return dict_id;
    }

    public int getDict_sort() {
        return dict_sort;
    }

    public String getDict_enable() {
        return dict_enable;
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public String getDict_memo() {
        return dict_memo;
    }

    public String getDict_item_name() {
        return dict_item_name;
    }

    public String getDict_item_code() {
        return dict_item_code;
    }
}
