package Java;

public final class ImmutableClass {

    private final String name;
    private final String pan;

    public ImmutableClass(String name, String pan){
        this.name = name;
        this.pan = pan;
    }

    public String getName() {
        return name;
    }

    public String getPan() {
        return pan;
    }

    public static void main(String[] args) {

        ImmutableClass ic = new ImmutableClass("Yashil", "ATYPJ4012E");
        System.out.println(ic.getName()  + " : "  +  ic.getPan());
        ImmutableClass t = new ImmutableClass("anc", "test");
        System.out.println(t.getName()  + " : "  +  t.getPan());

    }

}
