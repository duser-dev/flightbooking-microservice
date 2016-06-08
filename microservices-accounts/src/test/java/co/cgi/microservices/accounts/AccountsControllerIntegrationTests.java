package co.cgi.microservices.accounts;

import org.junit.runner.RunWith;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cgi.microservices.accounts.AccountsWebApplication;

/**
 * Spring Integration/System test - by using @SpringApplicationConfiguration
 * instead of @ContextConfiguration, it picks up the same configuration that
 * Spring Boot would use.
 *
 * @author Paul Chapman
 */

public class AccountsControllerIntegrationTests extends
        AbstractAccountControllerTests {

}
