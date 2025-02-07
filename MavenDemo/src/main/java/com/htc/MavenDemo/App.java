package com.htc.MavenDemo;

import java.io.File;

import com.htc.MavenDemo.Service.EmployeeService;
import com.htc.MavenDemo.Serviceimpl.EmployeeServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EmployeeService empService = new EmployeeServiceImpl();
        try {
        File file = new File("/Users/pranay/eclipse-workspace/MavenDemo/Employee.xlsx");  
        empService.readFromExcel(file);
        }catch(Exception e)
        {
        	System.out.println(e.getMessage()+" "+e.getClass());
        }
    }
}
