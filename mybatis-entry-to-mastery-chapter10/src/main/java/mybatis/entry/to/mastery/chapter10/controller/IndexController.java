package mybatis.entry.to.mastery.chapter10.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}
