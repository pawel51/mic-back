package pz1.MIC.controller;


import org.springframework.web.bind.annotation.*;
import pz1.MIC.model.Quest;
import pz1.MIC.model.User;
import pz1.MIC.service.QuestService;

@RestController
@RequestMapping("/quest")
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id){
        questService.delete(id);
    }

    @PostMapping
    public Quest addQuest(@RequestBody Quest quest){
        return questService.add(quest);
    }

    @GetMapping("{id}")
    public Quest getQuest(@PathVariable Long id)
    {
        return questService.show(id);
    }
}
