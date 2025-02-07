package com.htc.MavenDemo.Serviceimpl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.htc.MavenDemo.Exception.EmployeeException;
import com.htc.MavenDemo.Service.EmployeeService;
import com.htc.MavenDemo.dao.EmployeeDao;
import com.htc.MavenDemo.daoImpl.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
 
	 private EmployeeDao employeeDAO = new EmployeeDaoImpl();
	 private Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());
	
	@Override
	public boolean readFromExcel(File file) {
		
		 try {
			employeeDAO.readDataFromExcel(file);
			log.info("Employee Detail Loaded in DB");
			return true;
		} catch (IOException e) {
			log.severe(e.getMessage());
			return false;
		} catch (EmployeeException e) {
			log.severe(e.getErrrorOccuredTime()+"Error Message"+e.getErrorMessage());
			return false;
		} catch (SQLException e) {
			log.severe(e.getMessage());
			return false;
		}
		
	}
		
}
