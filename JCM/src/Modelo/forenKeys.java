/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ASUS_01
 */
public class forenKeys {
    public String table;
    public String tableReference;
    public String column;

    public forenKeys() {
    }

    public forenKeys(String table, String tableReference) {
        this.table = table;
        this.tableReference = tableReference;
    }

    public forenKeys(String table, String tableReference, String column) {
        this.table = table;
        this.tableReference = tableReference;
        this.column = column;
    }
    
    
    
    

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTableReference() {
        return tableReference;
    }

    public void setTableReference(String tableReference) {
        this.tableReference = tableReference;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "forenKeys{" + "table=" + table + ", tableReference=" + tableReference + ", column=" + column + '}';
    }
    
    
    
}
