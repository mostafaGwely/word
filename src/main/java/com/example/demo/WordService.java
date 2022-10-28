package com.example.demo;

import com.example.demo.Word;
import com.example.demo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordService {
    List<Integer> list;


    public WordService() {
        list = new ArrayList<Integer>();
        for (int i = 1 ; i <= 10 ; i++){
            for (int j = i ; j > 0 ; j--) {
                list.add(i);
            }
        }
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
