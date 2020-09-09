package Java;

public final class ImmutableClass {

    private final String name;
    private final String pan;
    private final Address address;

    public ImmutableClass(String name, String pan, Address address){
        this.name = name;
        this.pan = pan;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPan() {
        return pan;
    }

    public Address getAddress() throws CloneNotSupportedException{
        return (Address) address.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        ImmutableClass ic = new ImmutableClass("Yashil", "ATYUJ1013F", new Address("Saranya Soham", "A4 -Block", "Indore"));
        System.out.println(ic.getName()  + " : "+ ic.getPan() + ", " +ic.getAddress());
        Address address = ic.getAddress();
        address.setCity("San Jose");
        System.out.println(ic.getAddress());

        //ImmutableClass t = new ImmutableClass("anc", "test");
        //System.out.println(t.getName()  + " : "  +  t.getPan());

    }

}
