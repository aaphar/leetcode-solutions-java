package oop;

public class Main {
    public static void main(String[] args) {
//        Parent p = new Parent();
//        Parent c = new Child();
//        Child realChild = new Child();
//
//        p.greet();        // Hello from Parent
//        c.greet();        // Hello from Parent (static binding!)
//        realChild.greet();// Hello from Child

//        DD d = new DD();
//        d.A();

        A a = new B();

        A a2 = new C();

        a.Do(); // b-DO -> "B DO"
        a2.Do(); // c-DO

        a.Do2(); // b-do2
        a2.Do2(); // b-do2


        B b = new C();
        b.Do(); // c-do

        b.Do2(); // b-do2

    }
}


class A {

    public void Do() {
        System.out.println("A DO");
    }

    public void Do2() {
        System.out.println("A DO2");
    }
}

class B extends A {
    @Override
    public void Do() {
        System.out.println("B DO");
    }

    @Override
    public void Do2() {
        System.out.println("B Do2");
    }
}

class C extends B {

    @Override
    public void Do() {
        System.out.println("C DO");
    }
}


interface AA {
    default void A() {
        System.out.println("A");
    }
}

interface BB {
    default void A() {
        System.out.println("B");
    }
}

//interface CC extends BB, AA {
//
//
//}

class DD implements AA, BB {

    @Override
    public void A() {
        System.out.println("test");
    }
}


class Parent {
    static void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    static void greet() { // hides Parent.greet()
        System.out.println("Hello from Child");
    }
}


class PaymentService {
    CardService cardService;

    public void createPayment() {
        cardService.verifyCard();
    }
}

interface CardService {
    boolean verifyCard();
}

class CardServiceImpl implements CardService {

    @Override
    public boolean verifyCard() {
        return true;
    }
}

abstract class BaseCardService {
    boolean verifyCard() {
        return true;
    }
}


