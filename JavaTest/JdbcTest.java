import java.sql.*;
// public class Hello
// {
//     public static void main(String[] arg )
// {
//     System.out.println("Hello");
// }


public class JdbcTest {
   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      System.out.println("Hello VS Code");
      try {
         Class.forName("org.postgresql.Driver");
        // conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","");
        Connection c = null;
        c = DriverManager.getConnection("jdbc:postgresql://pumpmanager.cfz8b5qtamld.us-east-1.rds.amazonaws.com:5432/postgres", "postgres", "KeKafkaSa");
       //  stmt = conn.createStatement();
        // rs = stmt.executeQuery("SELECT * FROM users");
        System.out.println("Run success");

         while(rs.next()) {
            System.out.println(rs.getString("username") + "\t" + rs.getString("email"));
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      } finally {
         try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
      }
   }
}
