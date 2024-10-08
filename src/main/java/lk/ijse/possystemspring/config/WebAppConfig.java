/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:27
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.possystemspring")
@EnableWebMvc
public class WebAppConfig {
}
