package DesignPattern.Singleton;
// creating singleton using enum has thread safety, safety against serialization and deserialization, safety against cloning and even reflection
// It is the best and easy way to create singleton
public enum SingleTonEnum {
    INSTANCE;
    public static String getConfiguration(){
        return "test abcd";
    }
}
