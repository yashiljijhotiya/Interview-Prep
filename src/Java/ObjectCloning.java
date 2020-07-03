package Java;

public class ObjectCloning {

  public static void main(String[] args) throws  CloneNotSupportedException{
    /*
    * 1. Shallow Copy
    * 2. Deep Copy
    * 3. Cloning
    * */

    //1. shallow here we created only one object ie a and assigning it to b and if we change value of b it will also change
    // value of a coz here we are referencing to a object. so in heap memory there is only one object ie a and 2 references
    // a & b
    Address a = new Address("f2","bangalore", "India");
    Address b = a;
    System.out.println(a);
    System.out.println(b);
    b.city ="test";
    System.out.println(a);
    System.out.println(b);
    /*Deep Copy
    *
    * */
    Address c = new Address(a.firstLine, a.secondLine, a.city);
    System.out.println(c);
    c.city = "Indore";
    System.out.println(c);

    //deep copy
    Address add = (Address) a.clone();
    System.out.println(add);
  }
}
