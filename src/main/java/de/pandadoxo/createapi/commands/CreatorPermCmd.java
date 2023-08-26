///////////////////////////////
// Class coded by Pandadoxo  //
// on 020, 20.01.23 at 13:09     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi.commands;
import de.pandadoxo.createapi.CreateAPI;
import de.pandadoxo.createapi.creatorpermission.APermissionEntry;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreatorPermCmd implements CommandExecutor, TabCompleter {

    private final Plugin plugin;
    private final String PREFIX;
    private final String SYNTAX;

    public CreatorPermCmd(Plugin plugin, String PREFIX) {
        this.plugin = plugin;
        this.PREFIX = PREFIX;
        this.SYNTAX = PREFIX + "§cFalscher Syntax! Benutze: §e/creatorperm (set | unset | list) (<Permission>) (true | false)";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //Syntax
        if (args.length == 0 || args.length > 3) {
            sender.sendMessage(SYNTAX);
            return true;
        }

        //List or Reload
        if (args.length == 1) {

            //List
            if (args[0].equalsIgnoreCase("list")) {
                Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                    //Get Permissions
                    HashMap<String, Boolean> permissions = new HashMap<>();

                    // get permissionEntry
                    APermissionEntry permissionEntry = CreateAPI.getPermissionCore().getPermissionEntry(plugin);
                    if (permissionEntry != null) {
                        permissions.putAll(permissionEntry.load());
                    }

                    //Permissions empty
                    if (permissions.isEmpty()) {
                        sender.sendMessage(PREFIX + "§7Es sind noch §ckeine §bCreator§7-Rechte eingestellt");
                        return;
                    }

                    //Send Message
                    sender.sendMessage(PREFIX + "§bCreator §7Rechte:");

                    //Sort List
                    List<String> permissionKeys = new ArrayList<>(permissions.keySet());
                    permissionKeys.sort(String::compareTo);

                    //Send List
                    for (String permission : permissionKeys) {
                        sender.sendMessage("§b" + permission + " §7| " + (permissions.get(permission) ? "§a" : "§c") +
                                permissions.get(permission).toString().toLowerCase());
                    }

                });
                return true;
            }
        }

        //Unset
        if (args.length == 2 && args[0].equalsIgnoreCase("unset")) {
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                APermissionEntry permissionEntry = CreateAPI.getPermissionCore().getPermissionEntry(plugin);
                if (permissionEntry == null) {
                    sender.sendMessage(PREFIX + "§7Es ist §ckein PermissionEntry §7registriert!");
                    return;
                }

                if (permissionEntry.unset(args[1].toLowerCase())) {
                    sender.sendMessage(PREFIX + "§7Dem §bCreator §7wurde das Recht §e§o" + args[1].toLowerCase() +
                            " §centfernt");
                } else {
                    sender.sendMessage(PREFIX + "§7Dem §bCreator §7konnte das Recht §e§o" + args[1].toLowerCase() +
                            " §cnicht §7entfernt werden");
                }

            });
            return true;
        }

        //Set
        if (args.length == 3 && args[0].equalsIgnoreCase("set")) {
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                APermissionEntry permissionEntry = CreateAPI.getPermissionCore().getPermissionEntry(plugin);
                if (permissionEntry == null) {
                    sender.sendMessage(PREFIX + "§7Es ist §ckein PermissionEntry §7registriert!");
                    return;
                }

                String permission = args[1].toLowerCase();
                boolean value = args[2].equalsIgnoreCase("true");

                permissionEntry.set(permission, value);

                //Send Message
                sender.sendMessage(PREFIX + "§7Dem §bCreator §7wurde das Recht §e§o" + permission +
                        " §agesetzt");
                sender.sendMessage(PREFIX + "§7Wert: " + (value ? "§a" : "§c") + String.valueOf(value).toLowerCase());

            });
            return true;
        }

        sender.sendMessage(SYNTAX);
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> tocomplete = new ArrayList<>();
        List<String> complete = new ArrayList<>();

        if (args.length == 1) {
            tocomplete.add("set");
            tocomplete.add("unset");
            tocomplete.add("list");
            tocomplete.add("reload");
        }

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("unset")) {
                // tocomplete.addAll(creatorPermissions.keySet());
            }
        }

        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("set")) {
                tocomplete.add("true");
                tocomplete.add("false");
            }
        }

        for (String tc : tocomplete) {
            if (tc.toLowerCase().startsWith(args[args.length - 1].toLowerCase())) {
                complete.add(tc);
            }
        }
        return complete;
    }

}