package designPatternPrinciple;

import java.util.List;

import static designPatternPrinciple.Main.doSomething;

public class Main {

    List<String> address;

    public void setAddress(List<String> address) {
        for (String string : address) {
            address.add(new String(string));
        }
    }

    public static void main(String[] args) {
//        DeviceController deviceController = new DeviceController();
//        deviceController.start(new Computer());
//        deviceController.start(new Printer());

        Address addres = new Address();
        addres.street = "stree";
        Person person = new Person();
        person.name = "A";
        person.address = addres;

        Person person2 = new Person(person);
    }

    public static void doSomething() throws Exception {
        throw new Exception("Throwed exception");
    }
}


class Person {
    public String name;
    public Address address;

    public Person() {
    }

    // copy constructor
    public Person(Person person) {
        this.name = new String(person.name);
        this.address = new Address(person.address);
    }
}

class Address {
    public String street;

    public Address() {
    }

    public Address(Address address) {
        this.street = address.street;
    }
}


class Printer implements IDevice {

    // liskov principle
    @Override
    public void turnOn() throws Exception {
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println("log");
        }
    }
}


class DeviceController {

    // dependency injection method
    public void start(IDevice device) {
        try {
            device.turnOn();
        } catch (Exception e) {
            reportIssue();
        }
    }

    public void reportIssue() {
        System.out.println("Issue reported");
    }
}

class Computer implements IDevice {

    @Override
    public void turnOn() throws Exception {
        doSomething();
    }
}

interface IDevice {
    void turnOn() throws Exception;
}
