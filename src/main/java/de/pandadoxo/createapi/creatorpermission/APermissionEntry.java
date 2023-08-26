///////////////////////////////
// Class coded by Pandadoxo  //
// on 020, 20.01.23 at 12:25     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi.creatorpermission;

import org.bukkit.plugin.Plugin;

import java.util.HashMap;

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
    public abstract void create();

    public abstract void destroy();

    public abstract HashMap<String, Boolean> load();

    public abstract boolean unset(String permission);

    public abstract void set(String permission, boolean value);

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
