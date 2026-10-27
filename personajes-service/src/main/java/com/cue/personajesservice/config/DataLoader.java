package com.cue.personajesservice.config;

import com.cue.personajesservice.model.Personaje;
import com.cue.personajesservice.repository.PersonajeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonajeRepository repository;

    public DataLoader(PersonajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            // claseId references: 1=Warrior, 2=Mage, 3=Cleric, 4=Rogue, 5=Paladin
            repository.save(new Personaje("Thorin Ironforge", 12, 130, 1L));   // Warrior
            repository.save(new Personaje("Elara Moonwhisper", 10, 65, 2L));   // Mage
            repository.save(new Personaje("Brother Aldric", 8, 80, 3L));       // Cleric
            repository.save(new Personaje("Shadow Vex", 14, 95, 4L));          // Rogue
            repository.save(new Personaje("Sir Galahad", 11, 110, 5L));        // Paladin
            repository.save(new Personaje("Ragnar Stonefist", 15, 145, 1L));   // Warrior
            repository.save(new Personaje("Zara Flamecaster", 9, 55, 2L));     // Mage
            repository.save(new Personaje("Luna Nightshade", 13, 90, 4L));     // Rogue
            System.out.println(">>> Seed data loaded: 8 personajes inserted.");
        }
    }
}
