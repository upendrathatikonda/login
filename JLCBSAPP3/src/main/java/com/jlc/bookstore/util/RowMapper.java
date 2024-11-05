package com.jlc.bookstore.util; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
/* 
* @Author : Srinivas Dande 
* @company : Java Learning Center 
* */ 
public interface RowMapper { 
public Object mapRow(ResultSet rs) throws SQLException; 
} 
