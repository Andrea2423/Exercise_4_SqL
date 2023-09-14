package org.example;

import java.sql.*;


//use JDBC for executing a query on the jdbc:mysql://localhost:3306/newdb database that:
//adds a new string column of 30 chars called country to the students table
//populate the new column with Italy for 2 students and Germany for the other 2 students
public class Database {

    public static void main(String[] args) {
        //DriverManager.getConnection(
        //                    "jdbc:mysql://localhost:3306/Develhope",
        //                    "root", ",$rZ8JgBeUbR#cw");
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Develhope",
                    "root", ",$rZ8JgBeUbR#cw");

            Statement statement = connection.createStatement();

            statement.execute("ALTER TABLE students ADD COLUMN country VARCHAR(30)");
            Statement statementItaly = connection.createStatement();
            statementItaly.execute(
                    "UPDATE students SET country= \"Italy\" WHERE student_id <=2");
            Statement statementGermany = connection.createStatement();
            statementGermany.execute(
                    "UPDATE students SET country= \"Germany\" WHERE student_id<=4 AND student_id>2");
            connection.close();
            System.out.println("Colonna creata con successo!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}