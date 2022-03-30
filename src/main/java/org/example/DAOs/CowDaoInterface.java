package org.example.DAOs;

import org.example.DTOs.Cow;
import org.example.Exceptions.DaoExceptions;
import java.util.List;

public interface CowDaoInterface
{
    public List<Cow> findAllCows() throws DaoExceptions;
    public Cow findCowByTagID(int tag_id) throws DaoExceptions;
    public Cow addCow(int tag_id, String sex, String breed, int year, int month, int day, int milkYield) throws DaoExceptions;
    public Cow deleteCow(int tag) throws DaoExceptions;
    public List<Cow> findCowsUsingFilter() throws DaoExceptions;
    public String findAllCowsJSON() throws DaoExceptions;
    public String findCowByTagIDJSON(int tag_id) throws DaoExceptions;
}
