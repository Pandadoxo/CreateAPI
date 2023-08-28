package de.pandadoxo.createapi.creatorpermission;

import org.bukkit.plugin.Plugin;

public interface IPermissionEntryBuilder {

    APermissionEntry build(Plugin plugin, String database, String table, int priority);

}
