package pz1.MIC.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pz1.MIC.controller.request.CharacterRequest;
import pz1.MIC.controller.request.IdHolder;
import pz1.MIC.dto.CharacterDto;
import pz1.MIC.dto.CharacterEquipmentDto;
import pz1.MIC.dto.CharacterListDto;
import pz1.MIC.dto.StatsDto;
import pz1.MIC.enums.ClassEnum;
import pz1.MIC.model.*;
import pz1.MIC.model.Character;
import pz1.MIC.service.*;

import java.beans.Transient;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    private final ModelMapper mapper;
    private final UserDetailsService userDetailsService;
    private final RaceService raceService;
    private final ClassService classService;
    private final StatsService statsService;
    private final CharacterEquipmentService characterEquipmentService;
    private final ItemService itemService;
    private final BaseStatsService baseStatsService;


//    @PostMapping
//    public Character addCharacter(@RequestBody Character character, Principal principal, Long raceid, Long classid) {
//
//        User userObj = (User) userDetailsService.loadUserByUsername(principal.getName());
//        character.setUser(userObj);
//        Stats stats = new Stats();
//        character.setStats(stats);
//        CharacterEquipment characterEquipment = new CharacterEquipment();
//        character.setCharacterEquipment(characterEquipment);
//        Race race = raceService.show(raceid);
//        Class classes = classService.show(classid);
//
//        return characterService.add(character);
//    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody IdHolder idHolder){
        characterService.delete(idHolder.getId());
    }

    @PostMapping("/add")
    public CharacterDto addCharacterv2(@RequestBody CharacterRequest request, Principal principal) {
        User userObj = (User) userDetailsService.loadUserByUsername(principal.getName());
        Character character = mapper.map(request, Character.class);
//        character.toBuilder()
//                .user(userObj)
//                .stats(statsService.createStats(request.getClassEnum(), request.getRaceEnum()))
//                .characterEquipment()
//                .freePoints(10)
//                .build();
        character.setUser(userObj);
        character.setStats(statsService.createStats(request.getClassEnum(), request.getRaceEnum()));
        CharacterEquipment characterEquipment = new CharacterEquipment();
        character.setCharacterEquipment(characterEquipmentService.add(characterEquipment));
        characterEquipmentService.createNewEq(characterEquipment,request.getClasses());
        character.setFreePoints(10);
        return mapper.map(characterService.add(character), CharacterDto.class);
    }

    @GetMapping("/all")
    public List<CharacterListDto> getAllCharacters()
    {
        return characterService.getAll()
                .stream()
                .map(i -> mapper.map(i, CharacterListDto.class))
                .collect(Collectors.toList());

    }


    @GetMapping
    public CharacterDto getCharacter(Principal principalUser) {
        User userObj = (User) userDetailsService.loadUserByUsername(principalUser.getName());
        Character character = characterService.findbyuserid(userObj);
        return mapper.map(character, CharacterDto.class);
    }

    @GetMapping("/items")
    public List<CharacterEquipmentDto> getCharacterItems(Principal principal)
    {
        User userObj = (User) userDetailsService.loadUserByUsername(principal.getName());
        Character character =  characterService.findbyuserid(userObj);
        return itemService.getCharacterItems(character.getCharacterEquipment())
                .stream()
                .map(i -> mapper.map(i, CharacterEquipmentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/shop")
    public List<CharacterEquipmentDto> getCharacterShopItems(Principal principal)
    {
        User userObj = (User) userDetailsService.loadUserByUsername(principal.getName());
        Character character =  characterService.findbyuserid(userObj);
        return itemService.getCharacterItems(character.getCharacterEquipment())
                .stream()
                .map(i -> mapper.map(i, CharacterEquipmentDto.class))
                .collect(Collectors.toList());
    }
    @PutMapping("/classChange")
    public void updateClass(Principal principal,@RequestBody IdHolder idNewClass)
    {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        Character character = characterService.findbyuserid(user);
        BaseStats currentClassBaseStats = baseStatsService.show(classService.show(character.getClasses().getId()).getId());
        BaseStats newClassBaseStats = baseStatsService.show(classService.show(idNewClass.getId()).getId());
        statsService.updateClassChange(character.getStats(),currentClassBaseStats,newClassBaseStats);
        character.setClasses(classService.show(idNewClass.getId()));
        character = characterService.save(character);



    }

}
