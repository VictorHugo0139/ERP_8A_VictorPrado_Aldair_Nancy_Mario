/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
private static Conexion con;
    private static java.sql.Connection connection = null;
    private static final String url = "jdbc:sqlserver://";
    static String serverName;
    private static final String portNumber = "1433";
    private static final String databaseName = "ERP2020";
    private static String userName;
    private static String password;
    private final String statement = "select * from clientes;";
    // Informs the driver to use server a side-cursor,
    // which permits more than one active statement
    // on a connection.
    //private final String selectMethod = "Direct";
public static Conexion getInsConexion(){
    if(con==null){
        con= new Conexion();
    }                   
    return con;                     
}

public java.sql.Connection getConexion(){
    if(connection==null){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(getConnectionUrl(),
                    userName, password);
            if (connection != null) {
                System.out.println("Connection Successful!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
    }
    return connection;
}
    public void setUserName(String userName) {
        this.userName = userName; 
    }                                                      

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructor
    private Conexion() {
        
    }

    private static String getConnectionUrl() {
        try {
            InetAddress addr = InetAddress.getLocalHost();

//// IP
//byte[] ipAddr = addr.getAddress();
// hostname
            serverName = addr.getHostName();

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
        return url + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";";//+"selectMethod="+ selectMethod + ";";
    }

    
//
//    /*
//  * Display the driver properties, database details
//     */
//    public void displayDbProperties() {
//        java.sql.DatabaseMetaData dm = null;
//        java.sql.ResultSet result = null;
//        try {
//            connection = this.getConnection();
//            if (connection != null) {
//                dm = connection.getMetaData();
//                System.out.println("Driver Information");
//                System.out.println("\tDriver Name: " + dm.getDriverName());
//                System.out
//                        .println("\tDriver Version: " + dm.getDriverVersion());
//                System.out.println("\nDatabase Information ");
//                System.out.println("\tDatabase Name: " + dm.getDatabaseProductName());
//                System.out.println("\tDatabase Version: " + dm.getDatabaseProductVersion());
//
//                Statement select = connection.createStatement();
//                result = select.executeQuery(statement);
//
//                while (result.next()) {
//                    System.out.println("Nombre: " + result.getString(1) + "\n");
//                    System.out.println("Apellido: " + result.getString(2) + "\n");
//                    System.out.println("Dni: " + result.getString(3) + "\n");
//                }
//                result.close();
//                result = null;
//                closeConnection();
//            } else {
//                System.out.println("Error: No active Connection");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        dm = null;
//    }
//
    public void closeConnection() {
        try {
            if (connection != null) {
                System.out.println("Close conection");
                connection.close();
            }
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    public static void main(String[] args) throws Exception {
//        Conexion myDbTest = new Conexion();
//        myDbTest.displayDbProperties();
//    }
}
