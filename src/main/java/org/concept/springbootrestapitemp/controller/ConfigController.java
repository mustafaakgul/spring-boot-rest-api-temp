package org.concept.springbootrestapitemp.controller;

import org.concept.springbootrestapitemp.model.Config;
import org.concept.springbootrestapitemp.repository.ConfigRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/v1/config")
public class ConfigController {

    private ConfigRepository configRepository;

    public ConfigController(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @GetMapping("/configs/{id}")
    public ResponseEntity<Config> getConfig(@PathVariable Long id) {
        return configRepository.findById(id)
                .map(config -> ResponseEntity.ok().body(config))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/configs")
    //public ResponseEntity<Iterable<Config>> getConfigs() {
    public Iterable<Config> getConfigs() {
        return configRepository.findAll();
    }

    @PostMapping("/configs")
    public ResponseEntity<Config> createConfig(@RequestBody Config Config) {
        Config newConfig = configRepository.save(Config);
        try {
            return ResponseEntity.created(new URI("/rest/Config/" + newConfig.getId())).body(newConfig);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/configs/{id}")
    public ResponseEntity<Config> updateConfig(@RequestBody Config Config, @PathVariable Long id) {
        Config.setId(id);
        return ResponseEntity.ok().body(configRepository.save(Config));
    }

    @PutMapping("/configs/{id}/proper")
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

    @DeleteMapping("/config/{id}")
    public ResponseEntity deleteConfig(@PathVariable Long id) {
        configRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
