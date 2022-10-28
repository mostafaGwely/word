package com.example.demo;

import com.example.demo.Word;
import com.example.demo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class WordService {
    List<Integer> list;


    public WordService() {
        list = Arrays.asList(1,1,2,2,3,3,4,4,4,5,5,5,6,6,6,6,7,7,7,7,7,8,8,8,8,8,9,9,9,9,9,9,10,10,10,10,10,10);
    }

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
        List<Word> all = wordRepository.findByp(getRandomNumber());
        if (all.size() > 0){
            Random rand = new Random();
            return all.get(rand.nextInt(all.size()));
        }else {
            return getRandomWord();
        }
    }

    private int getRandomNumber(){
        Random rand = new Random();
        return  list.get(rand.nextInt(list.size()));
    }
}
