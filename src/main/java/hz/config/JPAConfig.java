package hz.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by xhz on 2017/11/17.
 */
@Configuration
@EntityScan("hz.cms.model")
@EnableJpaRepositories("hz.cms.dao")
public class JPAConfig {
}
