import java.sql.*;
public class Access extends Manager_login
{
    Access() throws SQLException
    {
    }//---------------------------------------------------------------------------------------------EMPLOYEE
    public void display6() throws SQLException
    {
        String querry = "SELECT  * FROM EMPLOYEE WHERE active_status = ?";
        int count = 1;
        try(PreparedStatement p = connection.prepareStatement(querry))
        {
            p.setString(1,"INACTIVE");
            ResultSet r = p.executeQuery();
            System.out.println("-".repeat(165));
            System.out.printf("| %-20s | %-15s | %-15s | %-20s | %-12s | %-15s | %-12s | %-15s |\n",
                    "Account Num", "Name", "Status", "Job Role", "Salary", "Mobile", "Aadhar", "PAN");
            System.out.println("-".repeat(165));
            while(r.next())
            {
                long acc = r.getLong("acc_num");
                String name = r.getString("user_name");
                String s = r.getString("active_status");
                String job  = r.getString("job_role");
                long sal = r.getLong("salary");
                long mob = r.getLong("mobile");
                long aadhar = r.getLong("aadhar");
                long pan = r.getLong("pan");
                String status = r.getString("active_status");
                // Printing data rows
                System.out.printf("| %-15d | %-15s | %-15s | %-20s | %-12d | %-15d | %-12d | %-15d |\n",
                        acc, name, status, job, sal, mob, aadhar, pan);
                System.out.println("-".repeat(165));
            }
        }
        catch(SQLException e )
        {
            System.out.println("Error  :"+e.getMessage());
        }
        //-------------------------------------------------------------------------permission for employee
        int num = 0;
        while(num!=3)
        {
            System.out.println(" ".repeat(50) + "Press 1 : To Activate Employee");
            System.out.println(" ".repeat(50) + "Press 2 : To Reject Employee");
            System.out.println(" ".repeat(50) + "Press 3 : RETURN TO MAIN PAGE");
            System.out.print("Enter your option : ");
            num = input.nextInt();
            if(num==1)
            {
                Activate_reject obj = new Activate_reject();
                obj.display9();
            }
            else if(num==2)
            {
                Activate_reject obj = new Activate_reject();
                obj.display10();
            }
        }
        //--------------------------------------------------------------------------
    }
    //--------------------------------------------------------------------------------------users
    public void display7() throws SQLException
    {
        String querry = "SELECT  * FROM USERS WHERE active_status = ?";
        int count = 1;
        try(PreparedStatement p = connection.prepareStatement(querry))
        {
            p.setString(1,"INACTIVE");
            ResultSet r = p.executeQuery();
            System.out.println("-".repeat(165));
            System.out.printf("| %-15s | %-15s | %-10s | %-25s | %-12s | %-15s | %-12s | %-20s | %-15s |\n",
                    "Name", "Active Status", "Gender", "Address", "Phone Num", "Aadhar Num", "PAN Num", "Passwords", "Account Num");
            System.out.println("-".repeat(165));
            while(r.next())
            {
                String name = r.getString("user_name");
                String s = r.getString("active_status");
                String gender = r.getString("gender");
                String add  = r.getString("address");
                long ph = r.getLong("phone_num");
                long aadhar = r.getLong("aadhar_num");
                long pan = r.getLong("pan_num");
                String pass = r.getString("passwords");
                long acc = r.getLong("account_num");
                System.out.print(count++);
                System.out.printf("| %-15s | %-15s | %-10s | %-25s | %-12d | %-15d | %-12d | %-20s | %-15d |\n",
                        name, s, gender, add, ph, aadhar, pan, pass, acc);
                System.out.println("-".repeat(165));
            }
        }
        catch(SQLException e )
        {
            System.out.println("Error  :"+e.getMessage());
        }
        //-------------------------------------------------------------------------permission for users
        int num = 0;
        while(num!=3)
        {
            System.out.println(" ".repeat(50) + "Press 1 : To Activate Users");
            System.out.println(" ".repeat(50) + "Press 2 : To Reject User");
            System.out.println(" ".repeat(50) + "Press 3 : RETURN TO MAIN PAGE");
            System.out.print("Enter your option : ");
            num = input.nextInt();
            if(num==1)
            {
                Activate_reject obj = new Activate_reject();
                obj.display12();
            }
            else if(num==2)
            {
                Activate_reject obj = new Activate_reject();
                obj.display13();
            }
        }
        //--------------------------------------------------------------------------
    }
}
