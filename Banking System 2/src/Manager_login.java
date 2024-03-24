import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Manager_login extends Mybank
{
    Scanner input = new Scanner(System.in);
    Manager_login() throws SQLException
    {
    }
    void display4() throws SQLException
    {
        boolean isValid = false;
        boolean flag = false;
        while(!isValid)
        {
            try {
                System.out.print("Enter your Aadhar ID : ");
                long aadhar = input.nextLong();
                System.out.println("Enter your Account Number : ");
                long acc = input.nextLong();
                System.out.print("Enter your Password : ");
                input.nextLine();
                String pass = input.nextLine();
                isValid = true;
                flag = check(connection, aadhar, acc, pass);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please input data properly - kindly re-enter.");
                input.next();
            }
        }
        if(!flag)
        {
            System.out.println(" ".repeat(53)+"❌[ACCES - DENIED]❌"+" ".repeat(10));
        }
        else
        {
            System.out.println(" ".repeat(53) + "✅[ACCESS - GRANTED]✅" + " ".repeat(50));
            int num =  0;
            while(num!=10)
            {
                int count_1 = Count.count1();
                int count_2 = Count.count2();
                int count_3 = Count.count3();
                int count_4= Count.count4();
                int count_5 = Count.count5();
                int count_6 = Count.count6();

                System.out.println(" ".repeat(50) + "PRESS 1 : View All Employee Details["+count_1+"]");
                System.out.println(" ".repeat(50) + "PRESS 2 : View All Users Details["+count_2+"]");
                System.out.println(" ".repeat(50) + "PRESS 3 : View [INACTIVE] Employee["+count_3+"]");
                System.out.println(" ".repeat(50) + "PRESS 4 : View [INACTIVE] Users["+count_4+"]");
                System.out.println(" ".repeat(50) + "PRESS 5 : View Less Minimum Balance [<1000] Account["+count_5+"]");
                System.out.println(" ".repeat(50) + "PRESS 6 : View Loan Applications["+count_6+"]");
                System.out.println(" ".repeat(50) + "PRESS 7 : Send Notification to Users");
                System.out.println(" ".repeat(50) + "PRESS 8 : Send Notification to Employees");
                System.out.println(" ".repeat(50) + "PRESS 9 : View Employee's Attendance List");
                System.out.println(" ".repeat(50) + "PRESS 10 : Back to Main Page...⬅️");
                System.out.print("Enter your Options : ");
                num = input.nextInt();
                if(num==1)
                {
                    Views obj = new Views();
                    obj.display8();
                }
                else if(num==2)
                {
                    Views obj = new Views();
                    obj.display11();
                }
                else if(num==3)
                {
                    Access obj = new Access();
                    obj.display6();
                }
                else if(num==4)
                {
                    Access obj = new Access();
                    obj.display7();
                }
                else if(num==7)
                {
                    Views obj = new Views();
                    obj.display11();
                    Message obj2 = new Message();
                    obj2.display14();
                }
                else if(num==8)
                {
                    Views obj = new Views();
                    obj.display8();
                    Message obj2 = new Message();
                    obj2.display17();
                }
                else if(num==9)
                {
                    attendance obj = new attendance();
                    obj.display19();
                }
                else if(num==5)
                {
                    Views obj = new Views();
                    obj.display32();
                }
                else if(num==6)
                {
                    Activate_reject obj = new Activate_reject();
                    obj.display26();
                }
            }
        }
    }
    public static boolean check(Connection connection,long aadhar,long acc,String pass)
    {
        String query  = "SELECT * FROM MANAGER WHERE aadhar = ? AND acc_num = ? AND passwords = ? AND active_status = 'ACTIVE'";
        try(PreparedStatement p = connection.prepareStatement(query))
        {
            p.setLong(1,aadhar);
            p.setLong(2,acc);
            p.setString(3,pass);
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
