package org.example.DTOs;

import java.util.Objects;

public class Schema {
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String ordinalPosition;
    private String columnDefault;
    private String isNullable;
    private String dataType;
    private String characterMaximumLength;
    private String characterOctetLength;
    private String numericPrecision;
    private String numericScale;
    private String datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String columnType;
    private String columnKey;
    private String extra;
    private String privileges;
    private String columnComment;
    private String isGenerated;
    private String generationExpression;

    public Schema(String tableCatalog, String tableSchema, String tableName, String columnName, String ordinalPosition,
                  String columnDefault, String isNullable, String dataType, String characterMaximumLength,
                  String characterOctetLength, String numericPrecision, String numericScale, String datetimePrecision,
                  String characterSetName, String collationName, String columnType, String columnKey, String extra,
                  String privileges, String columnComment,String isGenerated, String generationExpression)
    {
        this.tableCatalog = tableCatalog;
        this.tableSchema = tableSchema;
        this.tableName = tableName;
        this.columnName = columnName;
        this.ordinalPosition = ordinalPosition;
        this.columnDefault = columnDefault;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.characterMaximumLength = characterMaximumLength;
        this.characterOctetLength = characterOctetLength;
        this.numericPrecision = numericPrecision;
        this.numericScale = numericScale;
        this.datetimePrecision = datetimePrecision;
        this.characterSetName = characterSetName;
        this.collationName = collationName;
        this.columnType = columnType;
        this.columnKey = columnKey;
        this.extra = extra;
        this.privileges = privileges;
        this.columnComment = columnComment;
        this.generationExpression = generationExpression;
    }
    public String getTableCatalog()
    {
        return tableCatalog;
    }
    public void setTableCatalog(String tableCatalog)
    {
        this.tableCatalog = tableCatalog;
    }
    public String getTableSchema()
    {
        return tableSchema;
    }
    public void setTableSchema(String tableSchema)
    {
        this.tableSchema = tableSchema;
    }
    public String getTableName()
    {
        return tableName;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    public String getColumnName()
    {
        return columnName;
    }
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
    public String getOrdinalPosition()
    {
        return ordinalPosition;
    }
    public void setOrdinalPosition(String ordinalPosition)
    {
        this.ordinalPosition = ordinalPosition;
    }
    public String getColumnDefault()
    {
        return columnDefault;
    }
    public void setColumnDefault(String columnDefault)
    {
        this.columnDefault = columnDefault;
    }
    public String getIsNullable()
    {
        return isNullable;
    }
    public void setIsNullable(String isNullable)
    {
        this.isNullable = isNullable;
    }
    public String getDataType()
    {
        return dataType;
    }
    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }
    public String getCharacterMaximumLength()
    {
        return characterMaximumLength;
    }
    public void setCharacterMaximumLength(String characterMaximumLength)
    {
        this.characterMaximumLength = characterMaximumLength;
    }
    public String getCharacterOctetLength()
    {
        return characterOctetLength;
    }
    public void setCharacterOctetLength(String characterOctetLength)
    {
        this.characterOctetLength = characterOctetLength;
    }
    public String getNumericPrecision()
    {
        return numericPrecision;
    }
    public void setNumericPrecision(String numericPrecision)
    {
        this.numericPrecision = numericPrecision;
    }
    public String getNumericScale()
    {
        return numericScale;
    }
    public void setNumericScale(String numericScale)
    {
        this.numericScale = numericScale;
    }
    public String getDatetimePrecision()
    {
        return datetimePrecision;
    }
    public void setDatetimePrecision(String datetimePrecision)
    {
        this.datetimePrecision = datetimePrecision;
    }
    public String getCharacterSetName()
    {
        return characterSetName;
    }
    public void setCharacterSetName(String characterSetName)
    {
        this.characterSetName = characterSetName;
    }
    public String getCollationName()
    {
        return collationName;
    }
    public void setCollationName(String collationName)
    {
        this.collationName = collationName;
    }
    public String getColumnType()
    {
        return columnType;
    }
    public void setColumnType(String columnType)
    {
        this.columnType = columnType;
    }
    public String getColumnKey()
    {
        return columnKey;
    }
    public void setColumnKey(String columnKey)
    {
        this.columnKey = columnKey;
    }
    public String getExtra()
    {
        return extra;
    }
    public void setExtra(String extra)
    {
        this.extra = extra;
    }
    public String getPrivileges()
    {
        return privileges;
    }
    public void setPrivileges(String privileges)
    {
        this.privileges = privileges;
    }
    public String getColumnComment()
    {
        return columnComment;
    }
    public void setColumnComment(String columnComment)
    {
        this.columnComment = columnComment;
    }
    public String getGenerationExpression()
    {
        return generationExpression;
    }
    public void setGenerationExpression(String generationExpression)
    {
        this.generationExpression = generationExpression;
    }
    public String getIsGenerated()
    {
        return isGenerated;
    }
    public void setIsGenerated(String isGenerated)
    {
        this.isGenerated = isGenerated;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schema schema = (Schema) o;
        return Objects.equals(tableCatalog, schema.tableCatalog) && Objects.equals(tableSchema, schema.tableSchema)
                && Objects.equals(tableName, schema.tableName) && Objects.equals(columnName, schema.columnName)
                && Objects.equals(ordinalPosition, schema.ordinalPosition) && Objects.equals(columnDefault,
                schema.columnDefault) && Objects.equals(isNullable, schema.isNullable) &&
                Objects.equals(dataType, schema.dataType) && Objects.equals(characterMaximumLength,
                schema.characterMaximumLength) && Objects.equals(characterOctetLength, schema.characterOctetLength)
                && Objects.equals(numericPrecision, schema.numericPrecision) && Objects.equals(numericScale,
                schema.numericScale) && Objects.equals(datetimePrecision, schema.datetimePrecision) &&
                Objects.equals(characterSetName, schema.characterSetName) && Objects.equals(collationName,
                schema.collationName) && Objects.equals(columnType, schema.columnType) && Objects.equals(columnKey,
                schema.columnKey) && Objects.equals(extra, schema.extra) && Objects.equals(privileges, schema.privileges)
                && Objects.equals(columnComment, schema.columnComment) && Objects.equals(isGenerated, schema.isGenerated)
                && Objects.equals(generationExpression, schema.generationExpression);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(tableCatalog, tableSchema, tableName, columnName, ordinalPosition, columnDefault,
                isNullable, dataType, characterMaximumLength, characterOctetLength, numericPrecision, numericScale,
                datetimePrecision, characterSetName, collationName, columnType, columnKey, extra, privileges,
                columnComment, isGenerated, generationExpression);
    }
    @Override
    public String toString()
    {
        return "Schema{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", ordinalPosition='" + ordinalPosition + '\'' +
                ", columnDefault='" + columnDefault + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", dataType='" + dataType + '\'' +
                ", characterMaximumLength='" + characterMaximumLength + '\'' +
                ", characterOctetLength='" + characterOctetLength + '\'' +
                ", numericPrecision='" + numericPrecision + '\'' +
                ", numericScale='" + numericScale + '\'' +
                ", datetimePrecision='" + datetimePrecision + '\'' +
                ", characterSetName='" + characterSetName + '\'' +
                ", collationName='" + collationName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", columnKey='" + columnKey + '\'' +
                ", extra='" + extra + '\'' +
                ", privileges='" + privileges + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", isGenerated='" + isGenerated + '\'' +
                ", generationExpression='" + generationExpression + '\'' +
                '}';
    }
}
