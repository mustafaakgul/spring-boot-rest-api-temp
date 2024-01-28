package org.concept.springbootrestapitemp.controllers;

import org.concept.springbootrestapitemp.models.Config;
import org.concept.springbootrestapitemp.repositories.ConfigRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class ConfigController {

    private ConfigRepository configRepository;

    public ConfigController(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @GetMapping("/api/v1/configs/{id}")
    public ResponseEntity<Config> getConfig(@PathVariable Long id) {
        return configRepository.findById(id)
                .map(config -> ResponseEntity.ok().body(config))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rest/Configs")
    //public ResponseEntity<Iterable<Config>> getConfigs() {
    public Iterable<Config> getConfigs() {
        return configRepository.findAll();
    }

    @PostMapping("/rest/Config")
    public ResponseEntity<Config> createConfig(@RequestBody Config Config) {
        Config newConfig = configRepository.save(Config);
        try {
            return ResponseEntity.created(new URI("/rest/Config/" + newConfig.getId())).body(newConfig);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/rest/Config/{id}")
    public ResponseEntity<Config> updateConfig(@RequestBody Config Config, @PathVariable Long id) {
        Config.setId(id);
        return ResponseEntity.ok().body(configRepository.save(Config));
    }

    @PutMapping("/rest/proper/Config/{id}")
    public ResponseEntity<Config> updateConfigProper(@RequestBody Config Config, @PathVariable Long id, @RequestHeader("If-Match") Long ifMatch) {
        Optional<Config> existingConfig = configRepository.findById(id);
        if (existingConfig.isPresent()) {
            if (ifMatch == 7) {
                Config.setId(id);
                return ResponseEntity.ok().body(configRepository.save(Config));
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/rest/Config/{id}")
    public ResponseEntity deleteConfig(@PathVariable Long id) {
        configRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
