import java.sql.SQLException;
import java.util.regex.*;
public class Conditions extends register_employee
{
    Conditions() throws SQLException
    {
    }
    public static int display37(String g,String mail,long salary,String dob,long mob,long aadhar,long pan,String pass)//----employee cnditions
    {
        int c1 =checkgender(g);
        int c2=checkmail(mail);
        int c3=checksalary(salary);
        int c4=checkdob(dob);
        int c5=checkmob(mob);
        int c6=checkaadhar(aadhar);
        int c7=checkpan(pan);
        int c8 =check(pass);
        int sum = c1+c2+c3+c4+c5+c6+c7+c8;
        System.out.println("Name   : ✅");
        System.out.println((c1==1) ? "Gender : ✅" :  "Gender : ❌ ");
        System.out.println((c2==1) ? "MailId : ✅" :  "MailId : ❌ ");
        System.out.println("Jobrole: ✅");
        System.out.println((c3==1) ? "Salary : ✅" :  "Salary : ❌ ");
        System.out.println((c4==1) ? "DOB    : ✅" :  "DOB    : ❌ ");
        System.out.println((c5==1) ? "Mobile : ✅" :  "Mobile : ❌ ");
        System.out.println((c6==1) ? "Aadhar : ✅" :  "Aadhar : ❌ ");
        System.out.println((c7==1) ? "PanNum : ✅" :  "PanNum : ❌ ");
        System.out.println((c8==1) ? "Pass   : ✅" :  "Pass   : ❌ ");
        return sum;
    }
    private static int check(String pass)
    {
        int digit=0,upp=0,low=0,spl=0;
        for(int i = 0;i<pass.length();i++)
        {
            char c = pass.charAt(i);
            if(Character.isUpperCase(c))
            {
                upp = 1;
            }
            else if(Character.isLowerCase(c))
            {
                low = 1;
            }
            else if(Character.isDigit(c))
            {
                digit = 1;
            }
            else
            {
                spl=1;
            }
        }
        if(digit==1 && upp==1 && low==1 && spl==1)
        {
            return 1;
        }
        return 0;
    }

    private static int checkpan(long pan)
    {
        String input = Long.toString(pan);
        String pattern = "^\\d{6}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        while(m.find())
        {
            return 1;
        }
        return 0;
    }

    private static int checkaadhar(long aadhar)
    {
        String input = Long.toString(aadhar);
        String pattern = "^\\d{12}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        while(m.find())
        {
            return 1;
        }
        return 0;
    }
    private static int checkmob(long mob)
    {
        String input = Long.toString(mob);
        String pattern = "^\\d{10}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        while(m.find())
        {
            return 1;
        }
        return 0;
    }

    private static int checkdob(String dob)
    {
        String pattern = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[01])$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(dob);
        while (m.find())
        {
            return 1;
        }
        return 0;
    }

    private static int checksalary(long salary)
    {
        String input = Long.toString(salary);
        String pattern = "^\\d+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        while(m.find())
        {
            return 1;
        }
        return 0;
    }

    private static int checkmail(String mail)
    {

        if(mail.contains("gmail.com"))
        {
            return 1;
        }
        return 0;
    }

    private static int checkgender(String g)
    {
        if(g.equalsIgnoreCase("M") || g.equalsIgnoreCase("F"))
        {
            return 1;
        }
        return 0;
    }
    //----------------------------------------------------------------------------------------------------------user conditions
    public static int display38(String g,long mobile, long aadhar ,long pan,String pass)
    {
        int c1 =checkgender(g);
        int c2=checkmob(mobile);
        int c3=checkaadhar(aadhar);
        int c4=checkpan(pan);
        int c5 =check(pass);
        System.out.println("Name   : ✅");
        System.out.println((c1==1) ? "Gender : ✅" :  "Gender : ❌ ");
        System.out.println("Address   : ✅");
        System.out.println((c2==1) ? "Mobile : ✅" :  "Mobile : ❌ ");
        System.out.println((c3==1) ? "Aadhar : ✅" :  "Aadhar : ❌ ");
        System.out.println((c4==1) ? "PanNum : ✅" :  "PanNum : ❌ ");
        System.out.println((c5==1) ? "Pass   : ✅" :  "Pass   : ❌ ");
        int sum = c1+c2+c3+c4+c5;
        return sum;
    }
}
