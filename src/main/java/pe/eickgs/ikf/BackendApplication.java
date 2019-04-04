package pe.eickgs.ikf;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Controller
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BackendApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @GetMapping("/")
    public String swagger() {
        return "redirect:swagger-ui.html";
    }
}
