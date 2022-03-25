package org.example.Exceptions;

import java.sql.SQLException;

public class DaoExceptions  extends SQLException
{
    public DaoExceptions()
    {
        // not used
    }

    public DaoExceptions(String aMessage)
    {
        super(aMessage);
    }
}
