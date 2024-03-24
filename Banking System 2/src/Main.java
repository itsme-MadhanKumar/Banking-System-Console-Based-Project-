import java.util.*;
import java.sql.*;
import java.util.InputMismatchException;
class Mybank // Parrent Class
{
    //---------------------------connections---------------------------------------------------
    String url = "jdbc:mysql://localhost:3306/MYBANK";
    String user = "root";
    String passwords = "Universe9952@";
     Connection connection = DriverManager.getConnection(url,user,passwords);

    //-----------------------------------------------------------------------------------------
        String name;
        String gender;
        String address;
        long ph_num;
        long aadhar_num;
        long pan_num;
        long acc_num;
        String password;
        String status = "INACTIVE";
        int money = 0;

    Mybank() throws SQLException
    {

    }

    void set(String na,String gen,String add,long num,long adha,long pan,long acc,String pass,String status)
        {
            this.name = na;
            this.gender = gen;
            this.address = add;
            this.ph_num = num;
            this.aadhar_num = adha;
            this.pan_num = pan;
            this.acc_num = acc;
            this.password = pass;
            this.status =  status;
        }
    void display(Scanner input) throws SQLException
    {
        int num = 0;
        do
        {
            System.out.println(" ".repeat(50)+"Press 1  : Login as Manager");
            System.out.println(" ".repeat(50)+"Press 2  : Login as Employee");
            System.out.println(" ".repeat(50)+"Press 3  : Login as User");
            System.out.println(" ".repeat(50)+"Press 4  : New to Register");
            System.out.println(" ".repeat(50)+"Press 5  : EXIT");
            System.out.print(" ".repeat(0)+"Enter your Options : ");
            try
            {
                num = input.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("INVALID INPUT");
                input.next();
            }
            if(num==4)
            {
                register obj = new register();
                obj.display();  System.out.println(" ".repeat(50) + "✅[CREATED - SUCCESFULLY]✅" + " ".repeat(50));
            }
            else if(num==1)
            {
                Manager_login obj = new Manager_login();
                obj.display4();
                System.out.println(" ".repeat(53) + "✅[LOGGED - OUT]✅" + " ".repeat(50));
            }
            else if(num==2)
            {
                Employee_login obj = new Employee_login();
                obj.display5();
                System.out.println(" ".repeat(53) + "✅[LOGGED - OUT]✅" + " ".repeat(50));
            }
            else if(num==5)
            {
                System.out.println("\"Thank you for banking with us \"");
            }
            else if(num==3)
            {
                User_login obj = new User_login();
                obj.display17();
                System.out.println(" ".repeat(53) + "✅[LOGGED - OUT]✅" + " ".repeat(50));
            }
        }
        while(num!=5);

    }
}
public class Main
{
    public static void main(String[] args) throws SQLException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("-".repeat(100));
        System.out.println(" ".repeat(50)+ "WELCOME TO MY BANK");
        System.out.println("-".repeat(100));
        Mybank obj = new Mybank();
        obj.display(input);
    }
}