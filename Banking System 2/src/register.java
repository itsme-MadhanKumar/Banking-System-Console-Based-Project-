import java.sql.SQLException;
import java.util.*;
import java.util.InputMismatchException;
public class register extends Mybank // parrrent class for users and employee [REGISTER]
{
    Scanner input = new Scanner(System.in);
    register() throws SQLException
    {}
    void display()
    {

        int num1 = 0;
        while(num1!=3)
        {


            System.out.println(" ".repeat(50)+"PRESS 1 : REGISTER AS EMPLOYEE");
            System.out.println(" ".repeat(50)+"PRESS 2 : REGISTER AS USER");
            System.out.println(" ".repeat(50)+"PRESS 3 : RETURN TO MAIN PAGE");
            try
            {
                System.out.print("ENTER YOU OPTION : ");
                num1 = input.nextInt();
                if(num1>3)
                {
                    System.out.println("ENTER A VALID OPTION");
                }
                else
                {
                    switch (num1)
                    {
                        case 1 ->
                        {
                            register_employee obj3 = new register_employee();
                            obj3.display1();
                        }
                        case 2 ->
                        {
                            register_users obj2 = new register_users();
                            obj2.display3();
                        }
                    }
                    if (num1 == 3)
                    {
                        System.out.println("RE-DIRECTING TO MAIN PAGE ⬅️");
                        for (int i = 5; i >= 0; i--)
                        {
                            System.out.print("You will be in : " + i + "\r");
                            try
                            {
                                Thread.sleep(1000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println();
                            }
                        }
                    }
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("ENTER A VALID NUMBER -> ERROR FOUND : " + e.getMessage());
                input.next();
            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
