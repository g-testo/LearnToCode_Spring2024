package com.ps.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class DinosaurController {
    private ArrayList<String> dinos = new ArrayList<>(
            Arrays.asList("Tyrannosaurus", "Triceratops", "Velociraptor", "Stegosaurus", "Brachiosaurus")
    );

    @RequestMapping(path="/dinosays", method= RequestMethod.GET)
    public String whatever(@RequestParam(defaultValue = "Roar") String message){
        return "Dino says " + message;
    }

    @GetMapping("/dinosaurs/{id}") // /dinosaurs/1
    public String getDinosaur(@PathVariable int id){
        return dinos.get(id-1);
    }

}
