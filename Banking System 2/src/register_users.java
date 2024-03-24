import java.sql.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class register_users extends register // child class
{
    Scanner input = new Scanner(System.in);

    register_users() throws SQLException
    {
    }
    Random random = new Random();
    void display3() throws SQLException
    {
        boolean isValid = false;
        while(!isValid)
        {
            try {
                System.out.print("Enter your name  : ");
                String name = input.nextLine();
                System.out.print("Enter gender : ");
                String g = input.next();
                System.out.print("Enter your home address : ");
                input.nextLine();
                String address = input.nextLine();
                System.out.print("Enter your 10 Digit Mobile number : ");
                long mobile = input.nextLong();
                System.out.print("Enter your 12 Digit Aadhar number : ");
                long aadhar = input.nextLong();
                System.out.print("Enter your 6 Digit Pan number  : ");
                long pan = input.nextLong();
                System.out.println("KINDLY WAIT 10 SECONDS FOR GENERATING YOUR ACCOUNT NUMBER");
                long randomm = generate(random);
                //--------------------------
                for (int i = 10; i >= 0; i--) {
                    System.out.print("Will be in : " + i + "\r");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                //--------------------------
                System.out.println("YOUR NEW GENERATE ACCOUNT NUMBER : " + randomm);
                //------------------------
                System.out.println("ENTER THE ABOVE 10 DIGIT NUMBER FOR FURTHER PROCESSING : ");
                long acc = input.nextLong();
                input.nextLine();
                System.out.print("CREATE YOUR PASSWORD : ");
                String pass = input.nextLine();
                int count = Conditions.display38(g,mobile,aadhar,pan,pass)+2;
                set(name, g, address, mobile, aadhar, pan, acc, pass, status);
                int checkAccount = checkaccount(randomm,acc);
                if(count==7 && checkAccount==1)
                {
                    System.out.println("Entered Account Number : ✅");
                    isValid = true;
                    set(name, g, address, mobile, aadhar, pan, acc, pass, status);
                    //------------------------------------------------------------------------putin database

                    insertdata(connection, name, g, address, mobile, aadhar, pan, acc, pass, status, money,count+1);
                    //----------------------------------------------------------------------------------

                }
                else
                {


                    System.out.println((checkAccount==1) ? "Entered Account Number : ✅":  "Entered Account Number : ❌ ");
                    System.out.println("Some Invalid Inputs Kindly Re-Enter the All the Details");
                    System.out.println("PASS : ["+count+"/8]");
                    System.out.println("Press 5 : EXIT \nPress any Any Number continue");
                    System.out.print("Enter your Choice : ");
                    boolean ist = false;
                    while(!ist)
                    {
                        try
                        {
                            int num = input.nextInt();
                            input.nextLine();
                            if (num == 5)
                            {
                                isValid = true;
                            }
                            ist = true;
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Invalid Input");
                        }
                    }
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR : Account May Already Exist / Re Try Again / Invalid Input");
                input.next();
            }
        }
    }
    private static int checkaccount(long randomm, long acc)
    {
        if(randomm==acc)
        {
            return 1;
        }
        return 0;
    }
    public static long generate(Random random)
    {
        return 1000000000L + (long) (random.nextFloat() * 9000000000L);
    }
    public static void insertdata(Connection connection,String name,String gender,String address,long mobile,long aadhar,long pan,long acc,String pass,String status,long money,int count) {
        String query = "INSERT INTO USERS(user_name,gender,address,phone_num,aadhar_num,pan_num,account_num,passwords,active_status,money) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement p =connection.prepareStatement(query))
        {
            p.setString(1,name);
            p.setString(2,gender);
            p.setString(3,address);
            p.setLong(4,mobile);
            p.setLong(5,aadhar);
            p.setLong(6,pan);
            p.setLong(7,acc);
            p.setString(8,pass);
            p.setString(9,status);
            p.setLong(10,money);
            int affected = p.executeUpdate();
            if(affected>0)
            {
                System.out.println("PASS : ["+count+"/8]");
                System.out.println("YOUR DATA IS SENT TO BANKER LET WILL CONFIRM YOUR ACCOUNT SOON");
            }
            else
            {
                System.out.println("ERROR ON REGISTERING");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
