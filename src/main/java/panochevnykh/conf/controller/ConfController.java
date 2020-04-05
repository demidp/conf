package panochevnykh.conf.controller;

import org.springframework.web.bind.annotation.*;
import panochevnykh.conf.domain.Conference;
import panochevnykh.conf.form.SearchForm;
import panochevnykh.conf.service.ConferenceService;

import java.util.List;

@RestController
@RequestMapping("/api/conf")
public class ConfController {
    private final ConferenceService conferenceService;

    public ConfController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }


    @PostMapping(value = "addConference", consumes = "application/json")
    public void addConference(@RequestBody Conference conference) {
        conferenceService.create(conference);
    }

    @PostMapping(value = "addConferences", consumes = "application/json")
    public void addConferences(@RequestBody List<Conference> conferences) {
        conferences.forEach(this::addConference);
    }

    @GetMapping("getAll")
    public List<Conference> getAll() {
        return conferenceService.findAll();
    }

    @GetMapping("search")
    public List<Conference> search(SearchForm searchForm) {
        return conferenceService.findAll(searchForm);
    }
}
