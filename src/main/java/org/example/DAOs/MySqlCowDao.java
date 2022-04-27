package org.example.DAOs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.DTOs.Cow;
import org.example.DTOs.Schema;
import  org.example.Exceptions.DaoExceptions;
import org.example.SortType;
import org.example.milkYieldComparator;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySqlCowDao extends MySqlDao implements CowDaoInterface {
    @Override
    public List<Cow> findAllCows() throws DaoExceptions {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Cow> cowList_ = new ArrayList<>();

        try {
            connection = this.getConnection();
            String query = "SELECT * FROM COW";
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
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

        } catch (SQLException e) {
            throw new DaoExceptions("findAllCowsResultSet() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("findAllCows() " + e.getMessage());
            }
        }
        return cowList_;
    }

    @Override
    public Cow findCowByTagID(int tag_id) throws DaoExceptions {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        try {
            connection = this.getConnection();
            String query = "SELECT * FROM COW WHERE TAG_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tag_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int tagId = resultSet.getInt("TAG_ID");
                String sex = resultSet.getString("SEX");
                String breed = resultSet.getString("BREED");
                int year = resultSet.getInt("YEAR");
                int month = resultSet.getInt("MONTH");
                int day = resultSet.getInt("DAY");
                int milk_yield = resultSet.getInt("MILK_YIELD");
                c = new Cow(tagId, sex, breed, year, month, day, milk_yield);
            }
        } catch (SQLException e) {
            throw new DaoExceptions("findCowByTagID() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("findCowByTagID() " + e.getMessage());
            }
        }
        return c;
    }

    public Cow addCow(int tag_id, String sex, String breed, int year, int month, int day, int milkYield) throws DaoExceptions {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        try {
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

        } catch (SQLException e) {
            throw new DaoExceptions("addCow() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("addCow() " + e.getMessage());
            }
        }
        return c;
    }

    public List<Cow> deleteCow(int tag) throws DaoExceptions {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        List<Cow> cowList_ = new ArrayList<>();
        try {
            connection = this.getConnection();
            String query = "DELETE FROM COW WHERE TAG_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tag);
            preparedStatement.executeUpdate();
            Statement statement = connection.createStatement();
            resultSet = preparedStatement.executeQuery("SELECT * FROM COW");
            while (resultSet.next()) {
                int tagId = resultSet.getInt("TAG_ID");
                String sex = resultSet.getString("SEX");
                String breed = resultSet.getString("BREED");
                int year = resultSet.getInt("YEAR");
                int month = resultSet.getInt("MONTH");
                int day = resultSet.getInt("DAY");
                int milk_yield = resultSet.getInt("MILK_YIELD");
                c = new Cow(tagId, sex, breed, year, month, day, milk_yield);
                cowList_.add(c);
            }
        } catch (SQLException e) {
            throw new DaoExceptions("deleteCow() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("deleteCow() " + e.getMessage());
            }
        }
        return cowList_;
    }

    public List<Cow> findCowsUsingFilter() throws DaoExceptions {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Cow> cowList_ = new ArrayList<>();

        try {
            connection = this.getConnection();
            String query = "SELECT * FROM COW";
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int tagId = resultSet.getInt("TAG_ID");
                String sex = resultSet.getString("SEX");
                String breed = resultSet.getString("BREED");
                int year = resultSet.getInt("YEAR");
                int month = resultSet.getInt("MONTH");
                int day = resultSet.getInt("DAY");
                int milk_yield = resultSet.getInt("MILK_YIELD");
                Cow c = new Cow(tagId, sex, breed, year, month, day, milk_yield);
                cowList_.add(c);
                cowList_.sort(new milkYieldComparator());
            }

        } catch (SQLException e) {
            throw new DaoExceptions("findAllCowsResultSet() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("findAllCows() " + e.getMessage());
            }
        }
        return cowList_;
    }

    public String findAllCowsJSON() throws DaoExceptions {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Cow> cowList_ = new ArrayList<>();

        String JsonString;
        try {
            connection = this.getConnection();
            String query = "SELECT * FROM COW";
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
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

            Gson gsonParser = new GsonBuilder().setPrettyPrinting().create();
            JsonString = gsonParser.toJson(cowList_);
        } catch (SQLException e) {
            throw new DaoExceptions("findAllCowsResultSet() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("findAllCows() " + e.getMessage());
            }
        }
        return JsonString;
    }

    public String findCowByTagIDJSON(int tag_id) throws DaoExceptions
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cow c = null;
        String JsonString;
        try {
            connection = this.getConnection();
            String query = "SELECT * FROM COW WHERE TAG_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tag_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int tagId = resultSet.getInt("TAG_ID");
                String sex = resultSet.getString("SEX");
                String breed = resultSet.getString("BREED");
                int year = resultSet.getInt("YEAR");
                int month = resultSet.getInt("MONTH");
                int day = resultSet.getInt("DAY");
                int milk_yield = resultSet.getInt("MILK_YIELD");
                c = new Cow(tagId, sex, breed, year, month, day, milk_yield);
            }
            Gson gsonParser = new GsonBuilder().setPrettyPrinting().create();
            JsonString = gsonParser.toJson(c);
        } catch (SQLException e) {
            throw new DaoExceptions("findCowByTagID() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("findCowByTagID() " + e.getMessage());
            }
        }
        return JsonString;
    }
    public List<Schema> getInformationSchema() throws DaoExceptions
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Schema> schemaList = new ArrayList<>();
        try {
            connection = this.getConnection();
            String query = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'cow_database' AND TABLE_NAME = 'cow';";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tableCatalog = resultSet.getString("TABLE_CATALOG");
                String tableSchema = resultSet.getString("TABLE_SCHEMA");
                String tableName = resultSet.getString("TABLE_NAME");
                String columnName = resultSet.getString("COLUMN_NAME");
                String ordinalPosition = resultSet.getString("ORDINAL_POSITION");
                String columnDefault = resultSet.getString("COLUMN_DEFAULT");
                String isNullable = resultSet.getString("IS_NULLABLE");
                String dataType = resultSet.getString("DATA_TYPE");
                String characterMaximumLength = resultSet.getString("CHARACTER_MAXIMUM_LENGTH");
                String characterOctetLength = resultSet.getString("CHARACTER_OCTET_LENGTH");
                String numericPrecision = resultSet.getString("NUMERIC_PRECISION");
                String numericScale = resultSet.getString("NUMERIC_SCALE");
                String datetimePrecision = resultSet.getString("DATETIME_PRECISION");
                String characterSetName = resultSet.getString("CHARACTER_SET_NAME");
                String collationName = resultSet.getString("COLLATION_NAME");
                String columnType = resultSet.getString("COLUMN_TYPE");
                String columnKey = resultSet.getString("COLUMN_KEY");
                String extra = resultSet.getString("EXTRA");
                String privileges = resultSet.getString("PRIVILEGES");
                String columnComment = resultSet.getString("COLUMN_COMMENT");
                String isGenerated = resultSet.getString("IS_GENERATED");
                String generationExpression = resultSet.getString("GENERATION_EXPRESSION");
                Schema schema = new Schema(tableCatalog, tableSchema, tableName, columnName, ordinalPosition,
                        columnDefault, isNullable, dataType, characterMaximumLength, characterOctetLength,
                        numericPrecision, numericScale, datetimePrecision, characterSetName, collationName, columnType,
                        columnKey, extra, privileges, columnComment, isGenerated, generationExpression);
                schemaList.add(schema);
            }
        }
        catch (SQLException e) {
            throw new DaoExceptions("getInformationSchema() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoExceptions("getInformationSchema() " + e.getMessage());
            }
        }
        return schemaList;

    }
}
