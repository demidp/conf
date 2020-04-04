package panochevnykh.conf.controller;

import org.springframework.web.bind.annotation.*;
import panochevnykh.conf.domain.Conference;

import java.util.List;

@RestController
@RequestMapping("/api/conf")
public class ConfController {
    @GetMapping("hello")
    public String getHello() {
        return "Hello";
    }

    @PostMapping(value = "addConference", consumes = "application/json")
    public void addConference(@RequestBody Conference conference) {
        return;
    }

    @PostMapping(value = "addConferences", consumes = "application/json")
    public void addConferences(@RequestBody List<Conference> conference) {
        return;
    }
}
