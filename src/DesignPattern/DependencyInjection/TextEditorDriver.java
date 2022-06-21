package DesignPattern.DependencyInjection;
/* IOC is a principle in software engineering by which the control of objects
or portions of a program is transferred to a container or framework.
* */
public class            TextEditorDriver {

    public static void main(String[] args) {
        TextEditor editor1 = new TextEditor(new HindiSpellChecker());
        editor1.setWord("test");
        EnglishSpellSchecker englishSpellSchecker = new EnglishSpellSchecker();
        System.out.println(englishSpellSchecker.spellCheck(editor1.getWord()));

    }
}
