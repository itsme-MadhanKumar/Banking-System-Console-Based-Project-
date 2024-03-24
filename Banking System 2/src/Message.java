import java.util.*;
import java.sql.*;
public class Message extends Manager_login
{
    Message() throws SQLException
    {
    }
    public void display14() throws SQLException //--------------------------------------Message to users
    {
        int num = 0;
        while(num!=3)
        {
            System.out.println(" ".repeat(50) + "PRESS 1 : To Send Bulk Message to All Users");
            System.out.println(" ".repeat(50) + "PRESS 2 : To Send Specific Message to Users");
            System.out.println(" ".repeat(50) + "PRESS 3 : RETURN TO MAIN PAGE ⬅️");
            num = input.nextInt();
            if(num==1)
            {
                send_notify obj2 = new send_notify();
                obj2.display15();
            }
            else if(num==2)
            {
                send_notify obj2 = new send_notify();
                obj2.display16();
            }
            else if(num==3)
            {
                for (int i = 2; i >= 0; i--)
                {
                    System.out.print("Will be in : " + i + "\r");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    //-------------------------------------------------------------------------------
    public void display17() throws SQLException //--------------------------------------Message to employee
    {
        int num = 0;
        while(num!=3)
        {
            System.out.println(" ".repeat(50) + "PRESS 1 : To Send Bulk Message to All Employee");
            System.out.println(" ".repeat(50) + "PRESS 2 : To Send Specific Message to Employee");
            System.out.println(" ".repeat(50) + "PRESS 3 : RETURN TO MAIN PAGE ⬅️");
            num = input.nextInt();
            if(num==1)
            {
                send_notify obj = new send_notify();
                obj.display18();
            }
            else if(num==2)
            {
                send_notify obj = new send_notify();
                obj.display19();
            }
            else if(num==3)
            {
                for (int i = 10; i >= 0; i--)
                {
                    System.out.print("Will be in : " + i + "\r");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    //----------------------------------------------------------------------------------- Message to users less than < 1000
    public void display35() throws SQLException //--------------------------------------Message to users
    {
        int num = 0;
        while(num!=3)
        {
            System.out.println(" ".repeat(50) + "PRESS 1 : To Send Bulk Message to All Users");
            System.out.println(" ".repeat(50) + "PRESS 2 : To Send Specific Message to Users");
            System.out.println(" ".repeat(50) + "PRESS 3 : RETURN TO MAIN PAGE ⬅️");
            num = input.nextInt();
            if(num==1)
            {
                send_notify obj2 = new send_notify();
                obj2.display36();
            }
            else if(num==2)
            {
                send_notify obj2 = new send_notify();
                obj2.display16();
            }
            else if(num==3)
            {
                for (int i = 2; i >= 0; i--)
                {
                    System.out.print("Will be in : " + i + "\r");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
