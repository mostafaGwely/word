package com.example.demo;

import com.example.demo.Word;
import com.example.demo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public  Word getWord(long id){
        return  wordRepository.findById(id).get();
    }


    public Word getRandomWord(){
        List<Word> all = wordRepository.findAll();

        Random rand = new Random();
        return all.get(rand.nextInt(all.size()));

    }

}
