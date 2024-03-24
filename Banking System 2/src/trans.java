import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class trans extends user_functions
{
    LocalDate currentDate = LocalDate.now();
    // Formatting date
    String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalTime currentTime = LocalTime.now();
    // Formatting time
    String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    trans() throws SQLException
    {
    }
    void display31(long acc_num,long amt,String pass) //-------------------------------------------------trans of deposit
    {
        String query = "INSERT INTO TRANSACTIONS(acc_num1,dates,times,deposit,balance) VALUES(?,?,?,?,?)";
        try (PreparedStatement p = connection.prepareStatement(query))
        {
            user_functions obj = new user_functions();
                long amt1 = obj.display32(acc_num,pass);
                p.setLong(1,acc_num);
                p.setString(2,formattedDate);
                p.setString(3,formattedTime);
                p.setLong(4,amt);
                p.setLong(5,amt1);
                int rs = p.executeUpdate();
                if(rs>0)
                {
                    System.out.println("Succewss");
                }
                else
                {
                    System.out.println("no");
                }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    void display33(long acc_num,long amt,String pass) //-------------------------------------------------trans of withdraw
    {
        String query = "INSERT INTO TRANSACTIONS(acc_num1,dates,times,withdraw,balance) VALUES(?,?,?,?,?)";
        try (PreparedStatement p = connection.prepareStatement(query))
        {
            user_functions obj = new user_functions();
            long amt2 = obj.display32(acc_num,pass);
            p.setLong(1,acc_num);
            p.setString(2,formattedDate);
            p.setString(3,formattedTime);
            p.setLong(4,amt);
            p.setLong(5,amt2);
            int rs = p.executeUpdate();
            if(rs>0)
            {
                System.out.println("Succewss");
            }
            else
            {
                System.out.println("no");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------
    void display34(long acc1,long acc2,long amt,String pass) //-------------------------------------------------trans of withdraw
    {
        String query = "INSERT INTO TRANSACTIONS(acc_num1,acc_num2,dates,times,withdraw,balance) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement p = connection.prepareStatement(query))
        {
            user_functions obj = new user_functions();
            long amt2 = obj.display32(acc1,pass);
            p.setLong(1,acc1);
            p.setLong(2,acc2);
            p.setString(3,formattedDate);
            p.setString(4,formattedTime);
            p.setLong(5,amt);
            p.setLong(6,amt2);
            int rs = p.executeUpdate();
            if(rs>0)
            {
                System.out.println("Succewss");
            }
            else
            {
                System.out.println("no");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------user view of transaction
    public void display36(long acc_num)
    {
        String query  = "SELECT * FROM TRANSACTIONS WHERE acc_num1 = ?";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setLong(1,acc_num);
            System.out.println("+------------+------------+------------+------------+------------+------------+------------+");
            System.out.println("|   Acc Num  |   Acc Num  |   Date     |   Time     |  Deposit   |  Withdraw  |  Balance   |");
            ResultSet rs = p.executeQuery();
            while(rs.next())
            {
                long acc_num1 = rs.getLong("acc_num1");
                long acc_num2 = rs.getLong("acc_num2");
                String dates = rs.getString("dates");
                String time = rs.getString("times");
                long deposit = rs.getLong("deposit");
                long withdraw = rs.getLong("withdraw");
                long balances = rs.getLong("balance");


                System.out.println("+------------+------------+------------+------------+------------+------------+------------+");
                System.out.printf("| %-10d | %-10d | %-10s | %-10s | %-10d | %-10d | %-10d |\n", acc_num1, acc_num2, dates,time, deposit, withdraw, balances);

            }
            System.out.println("+------------+------------+------------+------------+------------+------------+------------+");
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
