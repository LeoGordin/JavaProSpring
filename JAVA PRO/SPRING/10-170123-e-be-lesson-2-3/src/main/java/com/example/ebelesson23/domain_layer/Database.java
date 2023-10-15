package com.example.ebelesson23.domain_layer;

import java.sql.SQLException;
import java.util.List;

public interface Database {

    void execute(String query) throws SQLException;

    List<User> select(String query) throws SQLException;
}
