public class test {
    public static void main(String[] args) {
        canRun a = new canRun();
        canRun b = new Cat();
        canRun e = new Dog();
        a.run(); // print run
        b.run(); // print cat can run
        Cat c = (Cat) b;
        c.eat(); // print cat eat fish
        Dog d = (Dog) e;
        d.eat();
    }
}

class canRun {
    void run() {
        System.out.println("run");
    }
}

class Cat extends canRun {
    void run() {
        System.out.println("cat can run");
    }

    void eat() {
        System.out.println("cat eat fish");
    }
}

class Dog extends canRun {
    void run() {
        System.out.println("dog can run");
    }

    void eat() {
        System.out.println("dog eat dog's food");
    }
}
