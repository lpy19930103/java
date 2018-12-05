package com.lpy.spring;


public class ProductDao {
    public void save() {
        System.out.println("保存商品。。。");
    }

    public void update() {
        System.out.println("更新商品。。。");
    }

    public String delete() {
        System.out.println("删除商品。。。");
        return "ProductDao delete";
    }

    public void find() {
        System.out.println("查找商品。。。");
    }


}
