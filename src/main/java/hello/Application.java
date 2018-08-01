package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class Application {
    
    private List<Feedback> feedbacks = new ArrayList<>();
   
    @RequestMapping("/")
    public String home() {
        return "<B>Hello Docker World<B>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/feedbacks")
    public List<Feedback> feedbacks() {
        return this.feedbacks;
    }
    
    @RequestMapping("/feeback")
    public String addFeedback() {
        return "";
    }
}
