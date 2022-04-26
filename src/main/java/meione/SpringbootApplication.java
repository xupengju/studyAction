package meione;

import meione.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Milo on 2022/4/24.
 * @description
 */
@RestController
@EnableWebMvc
@SpringBootApplication(scanBasePackages = "meione")
public class SpringbootApplication {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @RequestMapping("/system/health/check")
    public String health() {
        return "ok";
    }

}
