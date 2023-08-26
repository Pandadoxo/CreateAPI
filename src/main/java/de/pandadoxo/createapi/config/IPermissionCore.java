package de.pandadoxo.createapi.config;

import de.pandadoxo.createapi.creatorpermission.APermissionEntry;
import org.bukkit.plugin.Plugin;

public interface IPermissionCore {

    APermissionEntry getPermissionEntry(Plugin plugin);
}
