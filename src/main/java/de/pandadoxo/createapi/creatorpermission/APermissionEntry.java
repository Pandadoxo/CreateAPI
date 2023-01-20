///////////////////////////////
// Class coded by Pandadoxo  //
// on 020, 20.01.23 at 12:25     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi.creatorpermission;

public abstract class APermissionEntry {

    private final String database;
    private final String table;

    private final int priority;

    public APermissionEntry(String database, String table, int priority) {
        this.database = database;
        this.table = table;
        this.priority = priority;
    }

    public abstract void create();

    public abstract void destroy();

    public String getDatabase() {
        return database;
    }

    public String getTable() {
        return table;
    }

    public int getPriority() {
        return priority;
    }
}
