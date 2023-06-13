package common.configs;

public class CommonConfig {

    public static final String BROWSER = "EDGE";
    public static long IMPLICITLY_WAIT = 4;
    public static long EXPLICITLY_WAIT = 4;

    public static Boolean CLEAR_COOKIES_AND_STORAGE = true;
    public static Boolean CLOSE_BROWSER = true;

    public static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";


    public class InventoryPageConfigs{
        public static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/inventory.html";
        public static final String INVENTORY_TITLE = "Products";
    }

}
