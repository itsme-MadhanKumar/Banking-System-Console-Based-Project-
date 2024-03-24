import java.sql.SQLException;
import java.sql.*;
class Static_connections
{
    static Connection connections;

    static
    {
        try
        {
            connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYBANK","root","Universe9952@");
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
public class Count extends Static_connections
{
    public static  int count2()
    {
        int c1 = 0;
        String query = "SELECT COUNT(*) AS active_record_count FROM USERS WHERE active_status = 'ACTIVE'";
        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieving the count
            if (resultSet.next())
            {
                c1 = resultSet.getInt("active_record_count");
            }
            else
            {
                System.out.println("Not counted");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return c1;
    }
    //-----------------------------------------------------------------------------------------------------------
    public static  int count1()
    {
        int c1 = 0;
        String query = "SELECT COUNT(*) AS active_record_count FROM Employee WHERE active_status = 'ACTIVE'";


        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieving the count
            if (resultSet.next())
            {
                c1 = resultSet.getInt("active_record_count");
            }
            else
            {
                System.out.println("Not counted");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return c1;
    }
    //-----------------------------------------------------------------------------
    public static  int count3()
    {
        int c1 = 0;
        String query = "SELECT COUNT(*) AS active_record_count FROM EMPLOYEE WHERE active_status = 'INACTIVE'";


        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieving the count
            if (resultSet.next())
            {
                c1 = resultSet.getInt("active_record_count");
            }
            else
            {
                System.out.println("Not counted");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return c1;
    }
    //-----------------------------------------------------------------------------------------------------
    public static  int count4()
    {
        int c1 = 0;
        String query = "SELECT COUNT(*) AS active_record_count FROM USERS WHERE active_status = 'INACTIVE'";


        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieving the count
            if (resultSet.next())
            {
                c1 = resultSet.getInt("active_record_count");
            }
            else
            {
                System.out.println("Not counted");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return c1;
    }
    //-----------------------------------------------------------------------------------------------------
    public static  int count5()
    {

        String query = "SELECT COUNT(*)  FROM USERS WHERE money < 1000  AND active_status = 'ACTIVE'";

        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieving the count
            if (resultSet.next())
            {
                return resultSet.getInt(1);
            }
            else
            {
                System.out.println("Not counted");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
     return 0;
    }
    //---------------------------------------------------------------------
    public static  int count6()
    {
        int c1 = 0;
        String query = "SELECT COUNT(*) AS active_record_count FROM LOAN WHERE loan_status = 'NOT CONFIRMED'";
        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieving the count
            if (resultSet.next())
            {
                c1 = resultSet.getInt(1);
            }
            else
            {
                System.out.println("Not counted");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return c1;
    }
    //----------------------------------------------------------------------------------------------------------
    public static  int count7()
    {
        int c1;
        String query = "SELECT CASE WHEN Message IS NULL THEN 0 ELSE 1 END AS message_status FROM USERS";
        try (PreparedStatement statement = connections.prepareStatement(query))
        {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
            {
                c1 = resultSet.getInt(1);
                return c1;
            }
            else
            {
                System.out.println("Not counted");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
