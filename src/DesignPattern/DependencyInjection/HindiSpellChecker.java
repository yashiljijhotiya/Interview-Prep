package DesignPattern.DependencyInjection;

import java.util.HashSet;
import java.util.Set;

public class HindiSpellChecker  implements ISpellChecker{
    Set<String> hindiDictionary = new HashSet<>();
    @Override
    public boolean spellCheck(String word) {
        if(hindiDictionary.contains(word)){
            return true;
        }
        return false;
    }
}
