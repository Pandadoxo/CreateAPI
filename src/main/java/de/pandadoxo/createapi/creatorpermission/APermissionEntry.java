///////////////////////////////
// Class coded by Pandadoxo  //
// on 020, 20.01.23 at 12:25     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi.creatorpermission;

import de.pandadoxo.create.creatorpermission.PermissionEntry;
import org.bukkit.plugin.Plugin;

public abstract class APermissionEntry {

    private final Plugin plugin;
    private final String database;
    private final String table;
    private final int priority;

    public APermissionEntry(Plugin plugin, String database, String table, int priority) {
        this.plugin = plugin;
        this.database = database;
        this.table = table;
        this.priority = priority;
    }

    public static APermissionEntry from(Plugin plugin, String database, String table, int priority) {
        return new PermissionEntry(plugin, database, table, priority);
    }

    public abstract void create();

    public abstract void destroy();

    public Plugin getPlugin() {
        return plugin;
    }

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
