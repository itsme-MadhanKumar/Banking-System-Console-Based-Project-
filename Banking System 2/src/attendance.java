import java.util.*;
import java.sql.*;
public class attendance extends Mybank
{
    attendance() throws SQLException
    {

    }
    public void display19() // - --------------------------------------------VIEW ATTENDAACNE IN MANAGER LOGIN
    {
        String query = "SELECT acc_num,user_name,dates,log_in FROM ATTENDANCE";
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|    ID    |        Name        |     Date     |      Login     |");
        System.out.println("+---------------------------------------------------------------+");
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            ResultSet rs = p.executeQuery();
            while(rs.next())
            {
                long id = rs.getLong("acc_num");
                String user = rs.getString("user_name");
                String date = rs.getString("dates");
                String login = rs.getString("log_in");
                System.out.println(String.format("| %-10d | %-15s | %-12s | %-15s |\n", id, user, date, login));
            }
        }
        catch(SQLException e)
        {
            System.out.println("error : "+e.getMessage());
        }
    }
    public void display20(long acc,String name,String date,String login)
    {
        String sql = "INSERT INTO ATTENDANCE (acc_num,user_name,dates,log_in) VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setLong(1, acc);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, login);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("Data inserted successfully.");
            } else
            {
                System.out.println("Failed to insert data.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
}
