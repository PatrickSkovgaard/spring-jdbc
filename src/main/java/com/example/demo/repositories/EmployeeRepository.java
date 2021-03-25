package com.example.demo.repositories;

import com.example.demo.models.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository {

    public ArrayList<Employee> getAllEmployees (){

        ArrayList<Employee> empArr = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise_15-03", "Patrick", "beethoven");

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM emp");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
               /* int empNo = rs.getInt(1);
                String eName = rs.getString(2);
                String job = rs.getString(3);
                int mgrNo = rs.getInt(4);
                String hiredate = rs.getString(5);
                int sal = rs.getInt(6);
                int comm = rs.getInt(7);
                int deptNo = rs.getInt(8);
*/
                //Employee emps = new Employee(empNo, eName, job, mgrNo, hiredate, sal, comm, deptNo);
                Employee emps = new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));

                empArr.add(emps);
            }

            for (int i = 0; i < empArr.size(); i++){
                System.out.println(empArr.get(i));
            }
        }
        catch (SQLException e){
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }

        return empArr;
    }
}
