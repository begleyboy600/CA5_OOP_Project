package org.example.DAOs;

import org.example.DTOs.Cow;
import  org.example.Exceptions.DaoExceptions;

import java.sql.*;
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

    public Cow addCow(int tag_id, String sex, String breed, int year, int month, int day, int milkYield) throws DaoExceptions
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        try
        {
            connection = this.getConnection();
            String query = "INSERT INTO COW VALUES(?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tag_id);
            preparedStatement.setString(2, sex);
            preparedStatement.setString(3, breed);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, month);
            preparedStatement.setInt(6, day);
            preparedStatement.setInt(7, milkYield);
            preparedStatement.execute();
            c = new Cow(tag_id, sex, breed, year, month, day, milkYield);

        }
        catch (SQLException e)
        {
            throw new DaoExceptions("addCow() " + e.getMessage());
        }
        finally
        {
            try
            {
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
                throw new DaoExceptions("addCow() " + e.getMessage());
            }
        }
        return c;
    }

    public Cow deleteCow(int tag) throws DaoExceptions
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        try {
            connection = this.getConnection();
            String query = "DELETE FROM COW WHERE TAG_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tag);
            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();

            while (resultSet.next()) {
                int tagId_ = resultSet.getInt("TAG_ID");
                String sex_ = resultSet.getString("SEX");
                String breed_ = resultSet.getString("BREED");
                int year_ = resultSet.getInt("YEAR");
                int month_ = resultSet.getInt("MONTH");
                int day_ = resultSet.getInt("DAY");
                int milk_yield_ = resultSet.getInt("MILK_YIELD");
                c = new Cow(tagId_, sex_, breed_, year_, month_, day_, milk_yield_);

            }
        } catch (SQLException e)
        {
            throw new DaoExceptions("addCow() " + e.getMessage());
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
                throw new DaoExceptions("addCow() " + e.getMessage());
            }
        }
        return c;
    }


}
