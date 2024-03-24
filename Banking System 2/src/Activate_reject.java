import java.util.*;
import java.sql.*;
public class Activate_reject extends Access
{
    Activate_reject() throws SQLException
    {
    }
    public void display9()  throws SQLException// activate - EMPLOYEE
    {
        System.out.print("Enter the Account Number : ");
        long num = input.nextLong();
        System.out.print("Are you Sure Want to Activate the Employee [Y/N] : ");
        String accce = input.next();
        if(accce.equalsIgnoreCase("Y"))
        {
            String query = "SELECT * FROM EMPLOYEE WHERE active_status = ?";
            try (PreparedStatement p = connection.prepareStatement(query))
            {
                String updateQuery = "UPDATE EMPLOYEE SET active_status = 'ACTIVE' WHERE acc_num = ?";
                PreparedStatement update = connection.prepareStatement(updateQuery);
                update.setLong(1, num);
                int affected = update.executeUpdate();
                if (affected > 0) {
                    System.out.println(" ".repeat(50) + "ACTIVATED SUCCESFULLY");
                }
            } catch (SQLException e) {
                System.out.print("Error : " + e.getMessage());
            }
        }
        else
        {
            System.out.println("-----------ACTIVATION CALCELLED-----------------------");
        }
    }
    public void display10()//reject - EMPLOYEE
    {
        System.out.print("Enter the Account Number : ");
        long num = input.nextLong();
        System.out.print("Are you Sure Want to REJECT the Employee [Y/N] : ");
        String accce = input.next();
        if(accce.equalsIgnoreCase("Y")) {
            String query = "SELECT * FROM EMPLOYEE WHERE active_status = ?";
            try (PreparedStatement p = connection.prepareStatement(query)) {
                String updateQuery = "UPDATE EMPLOYEE SET active_status = 'REJECTED' WHERE acc_num = ?";
                PreparedStatement update = connection.prepareStatement(updateQuery);
                update.setLong(1, num);
                int affected = update.executeUpdate();
                if (affected > 0) {
                    System.out.println(" ".repeat(50) + "REJECTED SUCCESFULLY");
                }
            } catch (SQLException e) {
                System.out.print("Error : " + e.getMessage());
            }
        }
        else
        {
            System.out.println("-----------REJECTION CALCELLED-----------------------");
        }
    }
    //---------------------------------------------------------------------------------------
    //----------------------------------------------- ACTIVATE USERS
    public void display12()  throws SQLException// activate - user
    {
        System.out.print("Enter the Account Number : ");
        long num = input.nextLong();
        System.out.println("Are you Sure Want to Activate the User");
        String accce = input.next();
        if(accce.equalsIgnoreCase("Y")) {
            String query = "SELECT * FROM USERS WHERE active_status = ?";
            try (PreparedStatement p = connection.prepareStatement(query)) {
                String updateQuery = "UPDATE USERS SET active_status = 'ACTIVE' WHERE account_num = ?";
                PreparedStatement update = connection.prepareStatement(updateQuery);
                update.setLong(1, num);
                int affected = update.executeUpdate();
                if (affected > 0) {
                    System.out.println(" ".repeat(50) + "ACTIVATED SUCCESFULLY");
                }
            } catch (SQLException e) {
                System.out.print("Error : " + e.getMessage());
            }
        }
        else
        {
            System.out.println("-----------ACTIVATION CALCELLED-----------------------");
        }
    }
    //-----------------------------------------------------------------------------REJECT USERS
    public void display13()//reject  -  USERS
    {
        System.out.print("Enter the Account Number : ");
        long num = input.nextLong();
        System.out.println("Are you Sure Want to REJECT the USER");
        String accce = input.next();
        if(accce.equalsIgnoreCase("Y")) {
            String query = "SELECT * FROM USERS WHERE active_status = ?";
            try (PreparedStatement p = connection.prepareStatement(query))
            {
                String updateQuery = "UPDATE USERS SET active_status = 'REJECTED' WHERE account_num = ?";
                PreparedStatement update = connection.prepareStatement(updateQuery);
                update.setLong(1, num);
                int affected = update.executeUpdate();
                if (affected > 0) {
                    System.out.println(" ".repeat(50) + "REJECTED SUCCESFULLY");
                }
            } catch (SQLException e) {
                System.out.print("Error : " + e.getMessage());
            }
        }
        else
        {
            System.out.println("-----------REJECTION CALCELLED-----------------------");
        }
    }
    //-------------------------------------------------------------------------------------------------------
    public void display26() throws SQLException
    {
        String query = "SELECT * FROM LOAN WHERE acc_num IN (SELECT account_num FROM USERS WHERE active_status = 'ACTIVE')";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
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
        int num = 0;
        while(num!=2)
        {
            System.out.println(" ".repeat(50) + "Press 1 : To confirm amount");
            System.out.println(" ".repeat(50) + "Press 2 : RETURN TO MAIN PAGE");
            System.out.print("Enter your option : ");
            num = input.nextInt();
            if(num==1)
            {
                Activate_reject obj = new Activate_reject();
                obj.display27();
            }
        }
    }
    //-----------------------------------------------------------------------------------
    public void display27()  throws SQLException// activate - loan amount  -=------------------------------------------- confirmed
    {
        System.out.print("Enter the Account Number : ");
        long num = input.nextLong();
        System.out.println("Are you Sure Want to Activate the User");
        String accce = input.next();
        if(accce.equalsIgnoreCase("Y"))
        {
            String query = "SELECT * FROM LOAN WHERE loan_status = ?";
            try (PreparedStatement p = connection.prepareStatement(query))
            {
                String updateQuery = "UPDATE LOAN SET loan_status = 'CONFIRMED' WHERE acc_num = ?";
                PreparedStatement update = connection.prepareStatement(updateQuery);
                update.setLong(1, num);
                int affected = update.executeUpdate();
                if (affected > 0)
                {
                    //---------------------------------
                    user_functions obj = new user_functions();
                    obj.display28(num);
                    //----------------------------------
                }
            } catch (SQLException e)
            {
                System.out.print("Error : " + e.getMessage());
            }
        }
        else
        {
            System.out.println("-----------ACTIVATION CALCELLED-----------------------");
        }
    }
    //-----------------------------------------------------------------------------------
}
