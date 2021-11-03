package it.redhat.springbootdemo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class HelloController {

    @Autowired
    private Environment env;

    @GetMapping("/hello")
    public String index(Model model) {

	String startingMessage = "MY VERY FIRST DEPLOY! \n";
        String hostname = env.getProperty("HOSTNAME");
        String appMsg = env.getProperty("APP_MSG");
        if(!StringUtils.isEmpty(hostname) && !StringUtils.isEmpty(appMsg)){
            model.addAttribute("message2","APP_MSG from config-map is: "+appMsg);
        }
//        else if(!StringUtils.isEmpty(hostname)){
//            return startingMessage + "Greeting from "+hostname+"!!";
//        }

        model.addAttribute("message",startingMessage);
        return "hello";
    }

}
