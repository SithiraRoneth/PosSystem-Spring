/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:38
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "Customer"+ UUID.randomUUID();
    }
}
