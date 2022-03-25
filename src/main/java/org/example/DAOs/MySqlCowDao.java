package org.example.DAOs;

import org.example.DTOs.Cow;
import  org.example.Exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCowDao extends MySqlDao implements CowDaoInterface
{
    @Override
    public List<Cow> findAllCows() throws DaoExceptions
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Cow> cowList_ = new ArrayList<>();

        try
        {
            connection = this.getConnection();
            String query = "SELECT * FROM COW";
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                int tagId = resultSet.getInt("TAG_ID");
                String sex = resultSet.getString("SEX");
                String breed = resultSet.getString("BREED");
                int year = resultSet.getInt("YEAR");
                int month = resultSet.getInt("MONTH");
                int day = resultSet.getInt("DAY");
                int milk_yield = resultSet.getInt("MILK_YIELD");
                Cow c = new Cow(tagId, sex, breed, year, month, day, milk_yield);
                cowList_.add(c);
            }

        }
        catch (SQLException e)
        {
            throw new DaoExceptions("findAllCowsResultSet() " + e.getMessage());
        }
        finally
        {
            try
            {
                if(resultSet != null)
                {
                    resultSet.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(connection != null)
                {
                    freeConnection(connection);
                }
            }
            catch (SQLException e)
            {
                throw new DaoExceptions("findAllCows() " + e.getMessage());
            }
        }
        return cowList_;
    }

    @Override
    public Cow findCowByTagID(int tag_id) throws DaoExceptions
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        try
        {
            connection = this.getConnection();
            String query = "SELECT * FROM COW WHERE TAG_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tag_id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int tagId = resultSet.getInt("TAG_ID");
                String sex = resultSet.getString("SEX");
                String breed = resultSet.getString("BREED");
                int year = resultSet.getInt("YEAR");
                int month = resultSet.getInt("MONTH");
                int day = resultSet.getInt("DAY");
                int milk_yield = resultSet.getInt("MILK_YIELD");
                c = new Cow(tagId, sex, breed, year, month, day, milk_yield);
            }
        }
        catch (SQLException e)
        {
            throw new DaoExceptions("findCowByTagID() " + e.getMessage());
        }
        finally
        {
            try
            {
                if(resultSet != null)
                {
                    resultSet.close();
                }
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if(connection != null)
                {
                    freeConnection(connection);
                }
            }
            catch (SQLException e)
            {
                throw new DaoExceptions("findCowByTagID() " + e.getMessage());
            }
        }
        return c;
    }
}
