package DesignPattern.DependencyInjection;

public class TextEditor {
    private ISpellChecker spellChecker;
    private String word;
    public TextEditor(ISpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
