///////////////////////////////
// Class coded by Pandadoxo  //
// on 007, 07.12.22 at 14:20     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi;

import de.pandadoxo.createapi.config.ICreateEntry;
import de.pandadoxo.createapi.config.IPermissionCore;
import de.pandadoxo.createapi.creatorpermission.IPermissionEntryBuilder;

public class CreateAPI {

    private static CreateAPI instance;
    private static ICreateEntry createEntry;
    private static IPermissionCore permissionCore;

    private static IPermissionEntryBuilder permissionEntryBuilder;


    public CreateAPI(ICreateEntry createEntry, IPermissionCore permissionCore, IPermissionEntryBuilder permissionEntryBuilder) {
        CreateAPI.createEntry = createEntry;
        CreateAPI.permissionCore = permissionCore;
        CreateAPI.permissionEntryBuilder = permissionEntryBuilder;
    }

    public static void init(ICreateEntry createEntry, IPermissionCore permissionCore, IPermissionEntryBuilder permissionEntryBuilder) {
        if(CreateAPI.instance != null) {
            return;
        }

        CreateAPI.instance = new CreateAPI(createEntry, permissionCore, permissionEntryBuilder);
    }

    public static ICreateEntry getCreateEntry() {
        return createEntry;
    }

    public static IPermissionCore getPermissionCore() {
        return permissionCore;
    }

    public static IPermissionEntryBuilder getPermissionEntryBuilder() {
        return permissionEntryBuilder;
    }
}
