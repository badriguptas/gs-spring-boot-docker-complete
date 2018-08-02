package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class Application {
    
    private List<Feedback> feedbacks = new ArrayList<>();
    
    {
        Feedback f1 = new Feedback();
        f1.setComments("My First Comment");
        f1.setName("Badri");
        f1.setExperience("Good");
        feedbacks.add(f1);
    }
   
    @RequestMapping("/")
    public String home() {
        return "<h1>Hello Docker World</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/feedbacks")
    public List<Feedback> feedbacks() {
        return this.feedbacks;
    }
    
    @RequestMapping(value="/feeback", method=RequestMethod.POST)
    public String addFeedback(@RequestBody Feedback feedback) {
        if(feedback != null){
            this.feedbacks.add(feedback);
            return "OK";
        }
        return "NOT OK";
    }
}
