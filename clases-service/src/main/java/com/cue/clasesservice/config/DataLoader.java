package com.cue.clasesservice.config;

import com.cue.clasesservice.model.Clase;
import com.cue.clasesservice.repository.ClaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClaseRepository repository;

    public DataLoader(ClaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Clase("Warrior", "A fierce melee fighter with heavy armor and powerful strikes", "Tank", 10));
            repository.save(new Clase("Mage", "A master of arcane magic who casts devastating spells from afar", "DPS", 6));
            repository.save(new Clase("Cleric", "A divine healer who channels holy energy to restore allies", "Healer", 8));
            repository.save(new Clase("Rogue", "A stealthy assassin who deals critical damage from the shadows", "DPS", 8));
            repository.save(new Clase("Paladin", "A holy knight who protects allies and smites enemies with divine power", "Tank", 10));
            System.out.println(">>> Seed data loaded: 5 clases inserted.");
        }
    }
}
