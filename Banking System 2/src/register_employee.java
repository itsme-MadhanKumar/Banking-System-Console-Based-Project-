import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class register_employee extends register // child class
{
    register_employee() throws SQLException
    {
    }
    void display1() throws SQLException
    {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean isValid = false;

        while(!isValid)
        {
            try
            {
                System.out.print("Enter your name  : ");
                String name = input.nextLine();
                System.out.print("Enter gender : ");//-----
                //input.nextLine();
                String g = input.nextLine();
                System.out.print("Enter your E-Mail ID : ");//----

                String mail = input.nextLine();
                System.out.print("Enter your Job Role : ");
                String role = input.nextLine();
                System.out.print("Enter your Salary : ");//-----
                long salary = input.nextLong();
                System.out.print("Enter your DOB [YYYY-MM-DD] : ");//-----
                input.nextLine();
                String dob = input.nextLine();
                System.out.print("Enter your home address : ");
                // input.nextLine();
                String address = input.nextLine();
                System.out.print("Enter your 10 Digit Mobile number : ");//-----
                long mobile = input.nextLong();
                System.out.print("Enter your 12 Digit Aadhar number : ");//-----
                long aadhar = input.nextLong();
                System.out.print("Enter your 6 Digit Pan number  : ");//-----
                long pan = input.nextLong();
                System.out.println("KINDLY WAIT 10 SECONDS FOR GENERATING YOUR ACCOUNT NUMBER");
                long randomm = generate(random);
                //--------------------------
                for(int i = 10;i>=0;i--)
                {
                    System.out.print("Account number  will be in : " + i + "\r");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                //--------------------------
                System.out.println("YOUR NEW GENERATE ACCOUNT NUMBER : " + randomm);
                //------------------------
                System.out.println("ENTER THE ABOVE 10 DIGIT NUMBER FOR FURTHER PROCESSING : ");
                System.out.print("Enter your acount nuber  : ");//-------------
                long acc = input.nextLong();
                input.nextLine();
                System.out.print("CREATE YOUR PASSWORD MUST CONTAIN 8 CHARS,1 UPPER,1 LOWER,1 DIGIT,1 SPECIAL CHARACTER : ");//------
                String pass = input.nextLine();
                int count = Conditions.display37(g,mail,salary,dob,mobile,aadhar,pan,pass)+2;
                int checkAccount = checkaccount(randomm,acc);
                if(count== 10 && checkAccount==1)
                {
                    System.out.println("Entered Account Number : ✅");
                    set(name, g, address, mobile, aadhar, pan, acc, pass, status);
                    //--------------------------------------------------------------------------------putin database
                    insertdata1(connection, name, g, mail, role, salary, dob, address, mobile, aadhar, pan, acc, pass, status,count+1);
                    isValid = true;

                }
                else
                {

                    System.out.println((checkAccount==1) ? "Entered Account Number : ✅":  "Entered Account Number : ❌ ");
                    System.out.println("Some Invalid Inputs Kindly Re-Enter the All the Details");
                    System.out.println("PASS : ["+count+"/11]");
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
                        } catch (InputMismatchException e)
                        {
                            System.out.println("Invalid Input Re - Enter");
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

    public static long generate (Random random)
    {
        return 1000000000L + (long) (random.nextFloat() * 9000000000L);
    }
    public static void insertdata1 (Connection connection, String name,String gender, String gmail, String role,
                                    long s,  String dob, String address, long mobile,long aadhar, long pan, long acc, String pass, String status,int count) {
        String query = "INSERT INTO EMPLOYEE(user_name,gender,mailid,job_role,salary,dob,address,mobile,aadhar,pan,acc_num,passwords,active_status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement p = connection.prepareStatement(query))
        {
            p.setString(1, name);
            p.setString(2, gender);
            p.setString(3,gmail);
            p.setString(4, role);
            p.setLong(5, s);
            p.setString(6, dob);
            p.setString(7, address);
            p.setLong(8, mobile);
            p.setLong(9,aadhar);
            p.setLong(10, pan);
            p.setLong(11, acc);
            p.setString(12, pass);
            p.setString(13, status);
            int affected = p.executeUpdate();
            if(affected>0)
            {
                System.out.println("PASS : ["+count+"/11]");
                System.out.println("YOUR DATA IS SENT TO BANKER LET WILL CONFIRM YOUR ACCOUNT SOON");
            }
            else
            {
                System.out.println("ERROR ON REGISTEING");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
