///////////////////////////////
// Class coded by Pandadoxo  //
// on 007, 07.12.22 at 14:20     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi;

import de.pandadoxo.createapi.config.ICreateEntry;
import de.pandadoxo.createapi.config.IPermissionCore;

public class CreateAPI {

    private static CreateAPI instance;
    private static ICreateEntry createEntry;
    private static IPermissionCore permissionCore;


    public CreateAPI(ICreateEntry createEntry, IPermissionCore permissionCore) {
        CreateAPI.createEntry = createEntry;
        CreateAPI.permissionCore = permissionCore;
    }

    public static void init(ICreateEntry createEntry, IPermissionCore permissionCore) {
        if(CreateAPI.instance != null) {
            return;
        }

        CreateAPI.instance = new CreateAPI(createEntry, permissionCore);
    }

    public static ICreateEntry getCreateEntry() {
        return createEntry;
    }

    public static IPermissionCore getPermissionCore() {
        return permissionCore;
    }
}
