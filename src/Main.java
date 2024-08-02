import db.DBConnection;
import forms.StudentForm;


import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con!=null){
            System.out.println("Connection is conneted successfully");
        }
        else{
            System.out.println("Can't connect to database");
        }
        StudentForm loginForm = new StudentForm(null);
    }
}