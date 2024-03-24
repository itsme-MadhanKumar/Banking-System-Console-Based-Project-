import java.util.*;
import java.sql.*;
public class User_login extends Mybank
{
    User_login() throws SQLException
    {
    }
    Scanner input = new Scanner(System.in);
    public void display17() throws SQLException
    {
        boolean flag = false;
        boolean isValid = false;
        long acc_num = 0;
        String pass = "";
        while(!isValid)
        {
            try
            {
                System.out.print("Enter your Account_Num : ");
                 acc_num = input.nextLong();
                System.out.print("Enter your Password : ");
                input.nextLine();
                 pass = input.nextLine();
                 isValid = true;
               flag = check(acc_num,pass);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid Input Re - enter it again");
                input.next();
            }
        }
        int num = 0;
        if(!flag)
        {
            System.out.println(" ".repeat(53)+"❌[ACCES - DENIED]❌"+" ".repeat(10));
        }
        else
            System.out.println(" ".repeat(53) + "✅[ACCESS - GRANTED]✅" + " ".repeat(50));
         while(num!=9)
         {
            int count  = Count.count7();
            System.out.println(" ".repeat(50)+"PRESS 1 : Amount Deposit");
            System.out.println(" ".repeat(50)+"PRESS 2 : Amount Withdraw");
            System.out.println(" ".repeat(50)+"PRESS 3 : [Account to Account] Transaction");
            System.out.println(" ".repeat(50)+"PRESS 4 : View Your Account Balance"); // user_view
            System.out.println(" ".repeat(50)+"PRESS 5 : View Your Transaction Details"); // user_view
            System.out.println(" ".repeat(50)+"PRESS 6 : Apply Educational Loans");
            System.out.println(" ".repeat(50)+"PRESS 7 : Check Status of Loan");
            System.out.println(" ".repeat(50)+"PRESS 8 : Message from ["+count+"]"); //  user_view
            System.out.println(" ".repeat(50)+"PRESS 9 : RETURN TO MAIN PAGE");
            System.out.print("Enter your Option : ");
             boolean isits = false;
             while (!isits)
             {
                 try
                 {
                     num = input.nextInt();
                     isits = true;
                 } catch (InputMismatchException e)
                 {
                     System.out.println("Invalid Input");
                     System.out.print("Enter your Options : ");
                     input.nextLine();
                 }
             }
            if(num==8)
            {
                user_view obj = new user_view();
                obj.display18(acc_num,count);
            }
            else if(num==1)
            {
                user_functions obj1 = new user_functions();
                obj1.display24(acc_num,pass);
                user_functions obj = new user_functions();
                obj.display21(acc_num,pass);
            }
            else if(num==2)
            {
                user_functions obj1 = new user_functions();
                obj1.display24(acc_num,pass);
                user_functions obj = new user_functions();
                obj.display22(acc_num,pass);
            }
            else if(num==3)
            {
                user_functions obj = new user_functions();
                obj.display23(pass);
            }
            else if(num==4)
            {
                user_functions obj = new user_functions();
                obj.display24(acc_num,pass);
            }
            else if(num==6)
            {
                user_functions obj = new user_functions();
                obj.display25(acc_num);
            }
            else if(num==7)
            {
                Views obj = new Views();
                obj.display26(acc_num,pass);
            }
            else if(num==5)
            {
                trans obj = new trans();
                obj.display36(acc_num);
            }
        }
    }
    public boolean check(long acc_num,String passwords)
    {
        String query  = "SELECT * FROM USERS WHERE account_num = ? AND passwords = ? AND active_status = 'ACTIVE'";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setLong(1,acc_num);
            p.setString(2,passwords);
            try(ResultSet rs = p.executeQuery())
            {
                if(rs.next())
                {
                    return true;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error found : "+e.getMessage());
        }
        return false;
    }
}
