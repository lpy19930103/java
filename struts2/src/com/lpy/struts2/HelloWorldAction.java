package com.lpy.struts2;

import java.sql.SQLException;

public class HelloWorldAction {
    private String name;

    public String execute() throws SQLException {

        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
