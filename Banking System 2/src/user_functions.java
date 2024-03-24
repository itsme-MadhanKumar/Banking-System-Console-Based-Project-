import java.util.*;
import java.sql.*;
public class user_functions extends Mybank
{

    Scanner input= new Scanner(System.in);
    user_functions() throws SQLException
    {
    }
    public void display21(long acc_num,String pass) throws SQLException//-----------------------------------money deposit
    {
        System.out.print("Enter your Amount to Deposit : ");
        long amt = input.nextLong();
        String updateQuery = "UPDATE USERS SET Money = Money + ? WHERE account_num = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery))
        {
            updateStatement.setLong(1, amt);
            updateStatement.setLong(2, acc_num);
            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated > 0)
            {
               System.out.println("SUCCESS");
            }
            else
            {
                System.out.println("False");
            }
        }
        trans obj = new trans();
        obj.display31(acc_num,amt,pass);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------
    public void display22(long acc_num,String pass) throws SQLException//---------------------------money  withdraw
    //
    {
        System.out.print("Enter your Amount to Withdraw : ");
        long amt = input.nextLong();
        String updateQuery = "UPDATE USERS SET Money = Money - ? WHERE account_num = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery))
        {
            updateStatement.setLong(1, amt);
            updateStatement.setLong(2, acc_num);
            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("SUCCESS");
            }
            else
            {
                System.out.println("False");
            }
        }
        trans obj = new trans();
        obj.display33(acc_num,amt,pass);
    }
    //------------------------------------------------------------------------------------------------------------------------------------
    public void display23(String pass) throws SQLException
    {
        System.out.print("Enter your Account Number : ");
        long acc1 = input.nextLong();
        System.out.print("Enter Amount : ");
        long amt1 = input.nextLong();
        System.out.print("Enter Account Number to Transfer : ");
        long acc2 = input.nextLong();
        String SQL_TRANSFER = "UPDATE USERS SET Money = Money - ? WHERE account_num = ?";
        String SQL_DEPOSIT = "UPDATE USERS SET Money = Money + ? WHERE account_num = ?";

        try(PreparedStatement transferStmt = connection.prepareStatement(SQL_TRANSFER))
        {
            try(PreparedStatement depositStmt = connection.prepareStatement(SQL_DEPOSIT))
            {

            // Start transaction
            connection.setAutoCommit(false);

            // Withdraw from sender's account
            transferStmt.setLong(1, amt1);
            transferStmt.setLong(2, acc1);
            int updatedRowsTransfer = transferStmt.executeUpdate();

            // Deposit to receiver's account
            depositStmt.setLong(1, amt1);
            depositStmt.setLong(2, acc2);
            int updatedRowsDeposit = depositStmt.executeUpdate();

            // Commit transaction if both updates are successful
            if (updatedRowsTransfer == 1 && updatedRowsDeposit == 1)
            {
                connection.commit();
                System.out.println("Transaction successful.");
            } else
            {
                connection.rollback(); // Rollback if any update fails
                System.out.println("Transaction failed. Rollback performed.");
            }
        }
            catch (SQLException e)
        {
            e.printStackTrace();
        }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        trans obj = new trans();
        obj.display34(acc1,acc2,amt1,pass);
    }
    //-------------------------------------------------------------------------------------------------------------------------

    public void display24(long acc_num,String passwords)
    {

        String names = "";
        long balances  =0;
        String query = "SELECT user_name,money FROM USERS WHERE account_num = ? AND passwords = ?";
        try(PreparedStatement smt  = connection.prepareStatement(query))
        {
            smt.setLong(1,acc_num);
            smt.setString(2,passwords);
            try(ResultSet result = smt.executeQuery())
            {
                if(result.next())
                {
                    names = result.getString("user_name");
                    balances = result.getLong("money");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("FAILED TO RETRIEVE YOUR BALANCE");
        }
        System.out.println("+-------------------------------");
        System.out.println("Name : "+names);
        System.out.println("Current Balance : "+balances);
        System.out.println("+-------------------------------");
    }
    //----------------------------------------------------------------------------- Apply Loan
    public void display25(long acc_num)
    {
        String status = "NOT CONFIRMED";
        System.out.println("-".repeat(50) + "SAFE MODE ENABLED" + "-".repeat(50));
        System.out.print("Enter Student Name : ");
        String name = input.nextLine();
        System.out.print("Enter Institute Name : ");
        String insti = input.nextLine();
        System.out.print("Enter 10th Mark Percentage % : ");
        String ten = input.nextLine();
        System.out.print("Enter 12th Mark Percantage % : ");
        String twelve = input.nextLine();
        System.out.print("Enter Amount you need  : ");
        long amt = input.nextLong();
        System.out.print("Enter your Home Address : ");
        input.nextLine();
        String address  = input.nextLine();
        String query = "INSERT INTO LOAN(acc_num,namess,insti,ten,twelve,address,loan_status,amt) VALUES(?,?,?,?,?,?,?,?)";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setLong(1,acc_num);
            p.setString(2,name);
            p.setString(3,insti);
            p.setString(4,ten);
            p.setString(5,twelve);
            p.setString(6,address);
            p.setString(7,status);
            p.setLong(8,amt);
            int rs = p.executeUpdate();
            if(rs>0)
            {
                System.out.println("Sucess");
            }
            else
            {
                System.out.println("Not Success");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------- deposit loan amount in id
    public void display28(long acc_num) throws SQLException//-----------------------------------money deposit
    {
        System.out.print("Enter your Loan Amount  : ");
        long amt = input.nextLong();
        String updateQuery = "UPDATE USERS SET money = money + ? WHERE account_num = ? AND active_status = 'ACTIVE'";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery))
        {
            updateStatement.setLong(1, amt);
            updateStatement.setLong(2, acc_num);
            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("LOAN AMOUNT CONFIRMED");
            }
            else
            {
                System.out.println("LOAN AMOUNT NOT CONFIRMED");
            }
        }
    }
    //-------------------------------------------------------------------------------------using in trans for current balance
    public long display32(long acc_num,String passwords) throws SQLException
    {
        long balances  =0;
        String query = "SELECT user_name,money FROM USERS WHERE account_num = ? AND passwords = ?";
        try(PreparedStatement smt  = connection.prepareStatement(query))
        {
            smt.setLong(1,acc_num);
            smt.setString(2,passwords);
            try(ResultSet result = smt.executeQuery())
            {
                if(result.next())
                {
                    balances = result.getLong("money");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("FAILED TO RETRIEVE YOUR BALANCE");
        }
        return balances;
    }
}
