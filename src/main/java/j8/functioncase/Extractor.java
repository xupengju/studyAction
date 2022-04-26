package j8.functioncase;

/**
 * @author Milo on 2021/12/13.
 * @description
 */
public class Extractor {

    static String tenantId;

    public static String getTenantId() {
        return "Default";
    }

    public static void setTenantId(String specTenantId) {
        tenantId = specTenantId;
    }


    public static Object work(String s) {
        System.out.println("work s " + s);
        return  null;
    }
}
