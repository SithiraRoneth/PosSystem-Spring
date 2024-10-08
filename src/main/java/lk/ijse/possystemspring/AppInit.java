/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:32
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring;

import lk.ijse.possystemspring.config.WebAppConfig;
import lk.ijse.possystemspring.config.WebRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
