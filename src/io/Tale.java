package io;

public class Tale {

    public static void main(String[] args) {
        String type = "SAVING";
        String s = "a t t t t t";
        if(type.equals("SAVING")){
            String [] split = s.split(" ");
            if(split.length >= 3){
            System.out.println("firstName: "+ split[0]);
            System.out.println("middleName: "+split[1]);
            System.out.println("lastName: "+ split[3]);
        }
        else if(split.length == 2){
            System.out.println("firstName: "+ split[0]);
            System.out.println("middleName: "+split[1]);
            System.out.println("lastName: "+ "empty");
        }
        else {
                System.out.println("firstName: "+ s);
                System.out.println("middleName: empty");
                System.out.println("lastName: empty");
            }
        }else {
            System.out.println("firstName: "+ s);
            System.out.println("middleName: empty");
            System.out.println("lastName: empty");
        }
    }
}
