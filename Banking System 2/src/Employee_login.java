import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Employee_login extends Mybank
{
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter dates = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter l11 = DateTimeFormatter.ofPattern("HH:mm:ss");
    String date = currentDateTime.format(dates);
    String login = currentDateTime.format(l11);

    Scanner input = new Scanner(System.in);
    Employee_login() throws SQLException
    {
        System.out.println();
    }
    void display5() throws SQLException
    {
        boolean flag = false;
        boolean isValid = false;
        while(!isValid)
        {
            try
            {

                System.out.print("Enter your Account id : ");
                long acc = input.nextLong();
                System.out.print("Enter your User name : ");
                input.nextLine();
                String namess = input.nextLine();
                System.out.print("Enter Your password : ");
                String pass = input.nextLine();
                isValid = true;

                //---------------------------------------------------
                attendance objj = new attendance();
                objj.display20(acc,namess,date,login);
                //-------------------------------------------------
                flag = check(acc,pass);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid Input  - Re Enter Input");
                input.next();
            }
        }
        if(!flag)
        {
            System.out.println(" ".repeat(53)+"❌[ACCES - DENIED]❌"+" ".repeat(10));
        }
        else
        {
            System.out.println("LOG IN TIME : "+login);
            int num = 0;
            System.out.println(" ".repeat(53) + "✅[ACCESS - GRANTED]✅" + " ".repeat(50));
            while (num != 7)
            {
                int count_2 = Count.count2();
                int count_4 = Count.count4();
                int count_5 = Count.count5();
                int count_6 = Count.count6();
                System.out.println(" ".repeat(50) + "PRESS 1 : Create New Account For Users");
                System.out.println(" ".repeat(50) + "PRESS 2 : View All Users Details[" + count_2 + "]");
                System.out.println(" ".repeat(50) + "PRESS 3 : View [INACTIVE] Users[" + count_4 + "]");
                System.out.println(" ".repeat(50) + "PRESS 4 : View Less Minimum Balance [<1000] Account[" + count_5 + "]");
                System.out.println(" ".repeat(50) + "PRESS 5 : View Loan Applications[" + count_6 + "]");
                System.out.println(" ".repeat(50) + "PRESS 6 : Send Notification to Users");
                System.out.println(" ".repeat(50) + "PRESS 7 : Back to Main Page...⬅️");
                System.out.print("Enter your Options : ");
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
                if (num == 1)
                {
                    register_users obj2 = new register_users();
                    obj2.display3();
                }
                else if (num == 2)
                {
                    Views obj = new Views();
                    obj.display11();
                } else if (num == 3)
                {
                    Access obj = new Access();
                    obj.display7();
                } else if (num == 6)
                {
                    Message obj = new Message();
                    obj.display14();
                } else if (num == 5)
                {
                    Activate_reject obj = new Activate_reject();
                    obj.display26();
                } else if (num == 4)
                {
                    Views obj = new Views();
                    obj.display32();
                }
            }
        }
    }
    public boolean check(long acc_num,String pass)
    {
        String query  = "SELECT * FROM EMPLOYEE WHERE acc_num = ? AND passwords = ? AND active_status = 'ACTIVE'";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setLong(1,acc_num);
            p.setString(2,pass);
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
