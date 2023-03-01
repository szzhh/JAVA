package JdbcPrictice;

import java.sql.*;

public class database {

    public static void main(String[] args) {

        String  sql="Select* from user_t";

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC",
                    "root", "2338014914szh");
            System.out.println("数据库连接成功");
            st=con.createStatement();

            rs=st.executeQuery(sql);

            while(rs.next()){

                System.out.print(rs.getInt("id")+"   ");
                System.out.print(rs.getString("name")+"  ");
                System.out.print(rs.getString("password")+"  ");
                System.out.print(rs.getString("email")+"   ");
                System.out.println();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }finally{
            if(rs!=null) {
                try {
                    rs.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if(st!=null) {
                try {
                    st.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if(con!=null) {
                try {
                    con.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
