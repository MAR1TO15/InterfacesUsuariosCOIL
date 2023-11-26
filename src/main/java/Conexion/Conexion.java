
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    static String bd = "control";
    static String user ="root";
    static String url = "jdbc:mysql://localhost/"+bd+"?useSSL=false";
    static String pass = "";
    Connection conn = null;
    
    public Conexion(){
      try
      {
          Class.forName("com.mysql.jdbc.Driver"); 
          
          conn = DriverManager.getConnection(url, user, pass);
          
          if(conn != null){
              System.out.println("Exito en conectar");   
          }
      }catch(Exception e){
          System.out.println("Error de conexion");
      }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws Exception{
         conn.close();
    }
}
    