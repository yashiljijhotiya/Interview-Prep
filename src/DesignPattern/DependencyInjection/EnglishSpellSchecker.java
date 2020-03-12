package DesignPattern.DependencyInjection;

import java.util.HashSet;
import java.util.Set;

public class EnglishSpellSchecker implements ISpellChecker {

    Set<String> englishDictionary = new HashSet<>();

    public EnglishSpellSchecker(){
        englishDictionary.add("Thank You");
        englishDictionary.add("Welcome");
        englishDictionary.add("more");
    }

    @Override
    public boolean spellCheck(String word) {
       if(englishDictionary.contains(word)){
           return true;
       }
        return false;
    }
}
