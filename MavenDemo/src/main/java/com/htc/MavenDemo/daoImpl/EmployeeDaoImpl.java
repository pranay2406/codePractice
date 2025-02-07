package com.htc.MavenDemo.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.MavenDemo.Exception.EmployeeException;
import com.htc.MavenDemo.dao.EmployeeDao;
import com.htc.MavenDemo.entity.Employee;
import com.htc.MavenDemo.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public void readDataFromExcel(File file) throws IOException, EmployeeException, SQLException {

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Employee");

		Iterator<Row> rows = sheet.iterator();
		rows.next();
		
		while(rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
		while(cells.hasNext()) 
		{ Cell cell = cells.next(); 
		          String empid =cell.getStringCellValue(); 
				  System.out.print(empid+" ");
				  
				  cell=cells.next(); 
				  String empName = cell.getStringCellValue();
				  System.out.print(empName+" ");
				  
				  cell=cells.next(); 
				  String address = cell.getStringCellValue();
				  System.out.print(address+" ");
				  
				  cell=cells.next(); 
				  String designation = cell.getStringCellValue();
				  System.out.print(designation+" ");
				  
				  cell=cells.next(); 
				  float salary = (float) cell.getNumericCellValue();
				  System.out.println(salary);
				  
				  loadDataToDataBase(new Employee(empid, empName, address, designation,salary));
		}
	  }

	}

	public void loadDataToDataBase(Employee employee) throws SQLException, EmployeeException {

		if (employee == null) {
			throw new EmployeeException("Employee list is null or empty", LocalDateTime.now());
		}

		DBConnection dbconnect = new DBConnection();
		Connection con = dbconnect.getConnection();

		if (con != null) {
			try (PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?)")) {
				pstmt.setString(1, employee.getEmpId());
				pstmt.setString(2, employee.getEmpName());
				pstmt.setString(3, employee.getAddress());
				pstmt.setString(4, employee.getDesignation());

				if (employee.getSalary() > 0) {
					pstmt.setFloat(5, employee.getSalary());
				} else
					throw new EmployeeException("invalid Salary data found! please check the employee file",
							LocalDateTime.now());

				pstmt.execute();
			}
		} else
			throw new SQLException("DB connection not found");

	}
}