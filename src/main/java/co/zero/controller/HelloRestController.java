package co.zero.controller;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import co.zero.model.HelloModel;
import co.zero.repository.HelloRepository;

@RestController
public class HelloRestController {
    private HelloRepository repository;

    public HelloRestController(HelloRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public List<HelloModel> list() {
        return repository.findAll();
    }

    @PostMapping("/")
    public HelloModel create(@RequestBody HelloModel model) {
        return repository.save(model);
    }

    @GetMapping("/{id}")
    public Optional<HelloModel> find(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public HelloModel update(@PathVariable("id") String id, @RequestBody HelloModel model) {
        model.setId(id);
        return repository.save(model);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "::: ID deleted = " + id;
    }
}
