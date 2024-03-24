import java.sql.*;
public class send_notify extends Message
{
    send_notify() throws SQLException
    {
    }
    public void display15()//-----------------------------------------------------------------message for users bulk
    {
        System.out.print("ENTER YOUR MESSAGE Here ->: ");
        String str  = input.nextLine();
        String selectQuery = "SELECT * FROM USERS";
        try(PreparedStatement selectStatement = connection.prepareStatement(selectQuery))
        {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next())
            {
                long id = resultSet.getLong("account_num");
                String name = resultSet.getString("user_name");
                String message = "Dear " + name +"\n"+str ;
                String updateQuery = "UPDATE USERS SET Message = ? WHERE account_num = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, message);
                updateStatement.setLong(2, id);
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Message sent to user " + name + " (ID: " + id + ")");
                } else {
                    System.out.println("Failed to send message to user " + name + " (ID: " + id + ")");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void display16()//-------------------------------------------------------------------Message to users seperate
    {
        System.out.print("Enter the Account Id : ");
        long num = input.nextLong();
        System.out.print("ENTER YOUR MESSAGE Here ->: ");
        input.nextLine();
        String str  = input.nextLine();
        try (Connection connection = DriverManager.getConnection(url, user, passwords))
        {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet columns = metaData.getColumns(null, null, "USERS", "account_number");

            if (columns.next())
            {
                String selectQuery = "SELECT * FROM USERS WHERE account_num = ?";
                try(PreparedStatement selectStatement = connection.prepareStatement(selectQuery))
                {
                selectStatement.setLong(1,num);
                ResultSet resultSet = selectStatement.executeQuery();

                // Check if the user exists
                if (resultSet.next())
                {
                    String name = resultSet.getString("user_name");

                    // Send message to the user (replace this with your message sending logic)
                    String message = "Dear " + name +"\n"+str ;

                    // Update message column in the database
                    String updateQuery = "UPDATE USERS SET Message = ? WHERE account_num = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, message);
                    updateStatement.setLong(2,num);
                    int rowsUpdated = updateStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Message sent to user " + name + " (ID: " + num + ")");
                    } else
                    {
                        System.out.println("Failed to send message to user " + name + " (ID: " + num + ")");
                    }
                }
                else
                {
                    System.out.println("User with ID " + num + " not found.");
                }

            } catch (SQLException e)
                {
            e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Column 'account_number' does not exist.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void display18() //-------------------------------------------------------------------message for employee bulk
    {
        System.out.print("ENTER YOUR MESSAGE Here ->: ");
        String str  = input.nextLine();
        String selectQuery = "SELECT * FROM EMPLOYEE";
        try(PreparedStatement selectStatement = connection.prepareStatement(selectQuery))
        {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next())
            {
                long id = resultSet.getLong("acc_num");
                String name = resultSet.getString("user_name");
                String message = "Dear " + name +"\n"+str ;
                String updateQuery = "UPDATE EMPLOYEE SET Message = ? WHERE acc_num = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, message);
                updateStatement.setLong(2, id);
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0)
                {
                    System.out.println("Message sent to user " + name + " (ID: " + id + ")");
                }
                else
                {
                    System.out.println("Failed to send message to user " + name + " (ID: " + id + ")");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void display19() // ---------------------------------------------------------message for employee separate
    {
        System.out.print("Enter the Account Id : ");
        long num = input.nextLong();
        System.out.print("ENTER YOUR MESSAGE Here ->: ");
        input.nextLine();
        String str  = input.nextLine();
        try (Connection connection = DriverManager.getConnection(url, user, passwords))
        {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet columns = metaData.getColumns(null, null, "EMPLOYEE", "acc_num");

            if (columns.next())
            {
                String selectQuery = "SELECT * FROM EMPLOYEE WHERE acc_num = ?";
                try(PreparedStatement selectStatement = connection.prepareStatement(selectQuery))
                {
                    selectStatement.setLong(1,num);
                    ResultSet resultSet = selectStatement.executeQuery();

                    // Check if the user exists
                    if (resultSet.next())
                    {
                        String name = resultSet.getString("user_name");

                        // Send message to the user (replace this with your message sending logic)
                        String message = "Dear " + name +"\n"+str ;

                        // Update message column in the database
                        String updateQuery = "UPDATE EMPLOYEE SET Message = ? WHERE acc_num = ?";
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                        updateStatement.setString(1, message);
                        updateStatement.setLong(2,num);
                        int rowsUpdated = updateStatement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Message sent to user " + name + " (ID: " + num + ")");
                        } else
                        {
                            System.out.println("Failed to send message to user " + name + " (ID: " + num + ")");
                        }
                    }
                    else
                    {
                        System.out.println("User with ID " + num + " not found.");
                    }

                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Column 'account_number' does not exist.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------
    public void display36()//-----------------------------------------------------------------message for users bulk
    {
        System.out.print("ENTER YOUR MESSAGE Here ->: ");
        String str  = input.nextLine();
        String selectQuery = "SELECT * FROM USERS WHERE money < 1000 AND active_status = 'ACTIVE'";
        try(PreparedStatement selectStatement = connection.prepareStatement(selectQuery))
        {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next())
            {
                long id = resultSet.getLong("account_num");
                String name = resultSet.getString("user_name");
                String message = "Dear " + name +"\n"+str ;
                String updateQuery = "UPDATE USERS SET Message = ? WHERE account_num = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, message);
                updateStatement.setLong(2, id);
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0)
                {
                    System.out.println("Message sent to user " + name + " (ID: " + id + ")");
                } else {
                    System.out.println("Failed to send message to user " + name + " (ID: " + id + ")");
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
