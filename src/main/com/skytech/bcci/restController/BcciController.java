package com.skytech.bcci.restController;

import com.skytech.bcci.model.Player;
import com.skytech.bcci.servive.Implementation.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class BcciController {
    @Autowired
    private PlayerServiceImpl playerService;

    @GetMapping("/")
    public List<Player> getAll(){
        List<Player>  players =playerService.diplayAll();
        return players;
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable int id){
        Player player=playerService.getPlayerById(id);
        return player;
    }

    @DeleteMapping("/delete/{id}")
    public int deletePlayer(@PathVariable int id){
        int count=playerService.deletePlayer(id);
        return count;
    }

    @PostMapping("/create")
    public int createPlayer(@RequestBody Player player){
        int count=playerService.createPlayerEntry(player);
        return count;
    }
    @PutMapping("/update")
    public int updatePlayer(@RequestBody Player player){
        int count=playerService.updatePlayer(player);
        return count;
    }

    @GetMapping("/details/{email}")
    public Player details(@PathVariable String email){
        Player player=playerService.details(email);
        return player;
    }

}
