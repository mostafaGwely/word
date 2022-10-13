package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;

    public WordService getWordService() {
        return wordService;
    }

    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping
    public Word addWord(@RequestBody Word word){
        return wordService.save(word);
    }

    @GetMapping(path = "/{id}")
    public Word getWord(@PathVariable Long id){
        return wordService.getWord(id);
    }

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
}
