import java.sql.*;
public class user_view extends Mybank
{
    user_view() throws SQLException
    {
    }
    public void display18(long num,int c1) throws SQLException
    {
        String query = "SELECT Message FROM USERS WHERE account_num = ?";
        String updateQuery = "UPDATE USERS SET Message = NULL WHERE Message IS NOT NULL";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setLong(1, num);
            try(ResultSet rs = p.executeQuery())
            {
                while(rs.next())
                {
                    String message = rs.getString("Message");
                    System.out.println("-".repeat(50));
                    System.out.println("--->Message are shown below will Automatically delete ones you Seen !!!<---");
                    System.out.println(message);
                    System.out.println("-".repeat(50));
                }
            }
            catch(SQLException e)
            {
                System.out.println("Error : "+e.getMessage());
            }
            if (c1 == 1)
            {
                try (Statement updateStatement = connection.createStatement())
                {
                    int rowsAffected = updateStatement.executeUpdate(updateQuery);
                    System.out.println(rowsAffected + " rows updated.");
                } catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
