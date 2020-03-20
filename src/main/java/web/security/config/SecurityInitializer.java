package web.security.config;
/*
 *
 *@Data 12.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}