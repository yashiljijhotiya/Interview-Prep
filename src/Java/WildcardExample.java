package Java;

import java.util.ArrayList;
import java.util.List;

/*The question mark (?) is known as the wildcard in generic programming .
 It represents an unknown type. The wildcard can be used in a variety of
 situations such as the type of a parameter, field, or local variable;
 sometimes as a return type. Unlike arrays, different instantiations of
 a generic type are not compatible with each other, not even explicitly.
 This incompatibility may be softened by the wildcard if ? is used as an actual type parameter.

 Types of wildcards in Java:
 1 Upper Bound wildcards(<? extends T>) : In this argument can be any type.
 2 Lower Bound wildcards(<? super T>) : In this argument can be of Type or it can be a type of it's super class.
 3 Unbound wildcards(<?>):
*
* */
public class WildcardExample {

    public static void main(String[] args) {
        //diff between raw type and wildcard
        List<?> list = new ArrayList<String>();
        //list.add("string"); // does not compile
        //List<Object> objectList = new ArrayList<String>();// does not compile

        /* You can only add null-value to the List<?>
        *You can put any element into a collection with a raw type,
        * easily corrupting the collection’s type invariant(as demonstrated by the unsafeAdd method on page 112);
        *  you can’t put any element (other than null) into a Collection<?>.
        *
        * */

        List l = new ArrayList();
        l.add("");
        //use this to eliminate warning
        /*If you can’t eliminate a warning, but you can prove that the code that provoked the warning is typesafe,
         then (and only then) suppress the warning with an @SuppressWarnings("unchecked") annotation.
         Always use the SuppressWarnings annotation on the smallest scope possible.
         * */
        //@SuppressWarnings("unchecked")

        Object[] objArr = new Long[1];
        objArr[0] = "t";
    }
}
