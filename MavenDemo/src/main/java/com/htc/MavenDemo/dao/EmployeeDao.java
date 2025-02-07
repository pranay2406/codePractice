package com.htc.MavenDemo.dao;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.htc.MavenDemo.Exception.EmployeeException;
import com.htc.MavenDemo.entity.Employee;

public interface EmployeeDao {
		  public void readDataFromExcel(File file) throws IOException,EmployeeException, SQLException;
		  public void loadDataToDataBase(Employee employee) throws SQLException, EmployeeException;
}
