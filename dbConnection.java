import java.sql.*;

public class dbConnection{
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "Kofilo";
        String databaseUser = "root";
        String databasePassword = "Nml_19092002";
        String url = "jbdc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jbdc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}