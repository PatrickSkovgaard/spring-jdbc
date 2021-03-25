package com.example.demo.repositories;

import com.example.demo.models.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository {

    private Employee emps;

    public ArrayList<Employee> getAllEmployees (){

        ArrayList<Employee> empArr = new ArrayList<Employee>();

        try {
            System.out.println("0");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise_15-03", "Patrick", "beethoven");
            System.out.println("a");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM emp");
            System.out.println("b");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                emps = new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));

                empArr.add(emps);
                System.out.println("succes");
            }
        }
        catch (SQLException e){
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        System.out.println("c");
        return empArr;
    }
}
