package org.example.DAOs;

import org.example.DTOs.Cow;
import org.example.Exceptions.DaoExceptions;
import java.util.List;

public interface CowDaoInterface
{
    public List<Cow> findAllCows() throws DaoExceptions;

}
