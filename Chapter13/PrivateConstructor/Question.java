package Chapter13.PrivateConstructor;

public class Question {
    private Question() {
        System.out.println("Q");
    }

    static class A {
        private A() {
            System.out.println("A");
        }
    }

    static class B extends A {
        public B() {
        }
    }

    public static void main(String[] args) {
        new B();
    }

}