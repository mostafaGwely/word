package com.example.demo.service;

import com.example.demo.entity.Word;
import com.example.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public WordRepository getWordRepository() {
        return wordRepository;
    }

    public void setWordRepository(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word save(Word word){
        return wordRepository.save(word);
    }

}
