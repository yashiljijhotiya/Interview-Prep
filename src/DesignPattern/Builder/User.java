package DesignPattern.Builder;

public class User {
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final int age;
    private final String address;

    private  User(UserBuilder ub){
        this.firstName = ub.firstName;
        this.lastName = ub.lastName;
        this.address = ub.address;
        this.age = ub.age;
        this.phone = ub.phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class UserBuilder{

        private final String firstName;
        private final String lastName;
        private  String phone;
        private  int age;
        private  String address;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder address(String address){
            this.address = address;
            return this;
        }

        public UserBuilder phone(String phone){
            this.phone = phone;
            return this;
        }

        public UserBuilder age(int age){
            this.age = age;
            return this;
        }

        public User buildUser(){
            User u = new User(this);
            return  u;
        }


    }

    public static void main(String[] args) {
        User u1 = new UserBuilder("Yashil", "Jijhotiya").address("bangalore").age(26).buildUser();
        System.out.println(u1);
        User u2 = new UserBuilder("Shubhangi", "Yadav").address("California").buildUser();
        System.out.println(u2);
    }
}
