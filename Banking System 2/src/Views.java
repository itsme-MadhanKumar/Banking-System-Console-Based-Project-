import java.sql.*;
public class Views extends Manager_login
{
    Views() throws SQLException
    {
    }
    public void display8() throws SQLException //---------------------------------------------view of employee
    {
        int count = 1;
        String query = "SELECT * FROM EMPLOYEE WHERE active_status = ?";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setString(1,"ACTIVE");
            ResultSet r = p.executeQuery();
            System.out.printf("| %-18s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                    "NAMES", "STATUS", "GENDER", "ADDRESS", "PHONE NUMBER", "AADHAR NUMBER", "PAN NUMBER", "PASSWORDS", "ACCOUNT NUM");
            System.out.println("-".repeat(165));
            while(r.next())
            {
                String name = r.getString("user_name");
                String status = r.getString("active_status");
                String gender = r.getString("gender");
                String address  = r.getString("address");
                long phone = r.getLong("mobile");
                long aadhar = r.getLong("aadhar");
                long pan = r.getLong("pan");
                String password = r.getString("passwords");
                long account_num = r.getLong("acc_num");
                System.out.println("-".repeat(165));
                System.out.print(count++);
                // Printing data rows
                System.out.printf("| %-18s | %-15s | %-15s | %-15s | %-15d | %-15d | %-15d | %-15s | %-15d |\n",
                        name, status, gender, address, phone, aadhar, pan, password, account_num);
                // Printing table footer

            }
            System.out.println("-".repeat(165));
        }
        catch(SQLException e)
        {
            System.out.println("Error : "+e.getMessage());
        }
    }
    //---------------------------------------------------------------------------------view of USERS
    public void display11() throws SQLException
    {
        int count = 1;
        String query = "SELECT * FROM USERS WHERE active_status = ?";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setString(1,"ACTIVE");
            ResultSet r = p.executeQuery();
            System.out.println("-".repeat(165));
            System.out.printf("| %-20s | %-15s | %-10s | %-20s | %-12s | %-15s | %-12s | %-20s | %-15s |\n",
                    "Name", "Status", "Gender", "Address", "Phone", "Aadhar", "PAN", "Password", "Account Num");
            System.out.println("-".repeat(165));
            while(r.next())
            {
                String name = r.getString("user_name");
                String status = r.getString("active_status");
                String gender = r.getString("gender");
                String address  = r.getString("address");
                long phone = r.getLong("phone_num");
                long aadhar = r.getLong("aadhar_num");
                long pan = r.getLong("pan_num");
                String password = r.getString("passwords");
                long accountNum = r.getLong("account_num");
                System.out.print(count++);

                System.out.printf("| %-20s | %-15s | %-10s | %-20s | %-12d | %-15d | %-12d | %-20s | %-15d |\n",name, status, gender, address, phone, aadhar, pan, password, accountNum);
                System.out.println("-".repeat(165));
                // Printing table footer
            }

        }
        catch(SQLException e)
        {
            System.out.println("Error : "+e.getMessage());
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------------
    public void display25() throws SQLException//-----------------------------------------------------------------view less < 1000
    {
        String query = "SELECT * FROM USERS WHERE money < 1000 AND active_status = 'ACTIVE'";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery();
            // Printing the results in a table format
            System.out.println("+------------+-----------------+-------------------+");
            System.out.println("| Account ID |     Name        |     Balance       |");
            System.out.println("+------------+-----------------+-------------------+");
            while (resultSet.next())
            {
                long accountId = resultSet.getLong("account_num");
                String accountName = resultSet.getString("user_name");
                long balance = resultSet.getLong("money");
                System.out.printf("| %-10d | %-15s | %-10d |\n", accountId, accountName, balance);
            }
            System.out.println("+------------+-----------------+-------------------+");
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
        Message obj = new Message();
        obj.display14();
    }
    //------------------------------------------------------------------------------------------------------------------------------
    public void display26(long acc_num,String pass)
    {
        String query = "SELECT * FROM LOAN WHERE acc_num = ? AND EXISTS (SELECT 1 FROM USERS WHERE account_num = ? AND passwords = ? AND active_status = 'ACTIVE')";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setLong(1, acc_num);
            statement.setLong(2, acc_num);
            statement.setString(3, pass);
            ResultSet resultSet = statement.executeQuery();
            // Printing the results in a table format
            System.out.println("+------------+-----------------+------------------------+------------+------------+-----------------------+-----------+----------------+");
            System.out.println("| Account ID |     Name        |        INSTITUTE       |  10th Mark |  12th Mark |          Address      |  Money    |     Status     |");
            System.out.println("+------------+-----------------+------------------------+------------+------------+-----------------------+-----------+----------------+");
            while (resultSet.next())
            {
                long accountId = resultSet.getLong("acc_num");
                String accountName = resultSet.getString("namess");
                String insti = resultSet.getString("insti");
                String ten = resultSet.getString("ten");
                String twelve = resultSet.getString("twelve");
                String address = resultSet.getString("address");
                long amt = resultSet.getLong("amt");
                String status = resultSet.getString("loan_status");
                System.out.printf("| %-10d | %-15s | %-22s | %-10s | %-10s | %-21s | %-10d | %-13s |\n", accountId, accountName,insti,ten,twelve,address,amt,status);
            }
            System.out.println();
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------
    public void display32() throws SQLException//-----------------------------------------------------------------view less < 1000
    {
        String query = "SELECT * FROM USERS WHERE money < 1000 AND active_status = 'ACTIVE'";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery();
            // Printing the results in a table format
            System.out.println("+------------+-----------------+-------------------+");
            System.out.println("| Account ID |     Name        |     Balance       |");
            System.out.println("+------------+-----------------+-------------------+");
            while (resultSet.next())
            {
                long accountId = resultSet.getLong("account_num");
                String accountName = resultSet.getString("user_name");
                long balance = resultSet.getLong("money");
                System.out.printf("| %-10d | %-15s | %-10d |\n", accountId, accountName, balance);
            }
            System.out.println("+------------+-----------------+-------------------+");
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
        Message obj = new Message();
        obj.display35();
    }
}
