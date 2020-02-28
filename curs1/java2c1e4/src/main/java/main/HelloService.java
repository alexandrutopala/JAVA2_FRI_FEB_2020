package main;

public class HelloService {

    @Log("log hello")
    public void sayHello() {
        System.out.println("Hello");
    }

    @Log("log say bye")
    public void sayBye() {
        System.out.println("Bye");
    }
}
