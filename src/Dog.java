public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void foo(Dog d) {
        System.out.println(d.getName().equals("Max")); // true
        System.out.println(d);
        // change d inside of foo() to point to a new Dog instance construct red with name member variable set to "Fifi"
        d = new Dog("Fifi");
        System.out.println(d);
        System.out.println(d.getName().equals("Fifi")); // true
    }
}
