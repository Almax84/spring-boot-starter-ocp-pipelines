package it.redhat.springbootdemo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String index() {

        String hostname = env.getProperty("HOSTNAME");
        String appMsg = env.getProperty("APP_MSG");
        if(!StringUtils.isEmpty(hostname) && !StringUtils.isEmpty(appMsg)){
            return "Greeting from "+hostname+"!!"+" APP_MSG read from environment is: "+appMsg;
        }
        else if(!StringUtils.isEmpty(hostname)){
            return "Greeting from "+hostname+"!!";
        }

        return "Greetings from Spring Boot!";
    }

}