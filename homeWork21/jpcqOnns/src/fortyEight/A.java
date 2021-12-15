package fortyEight;

class A {
    void methodA() {
        System.out.println("AAAA");
    }

    class B extends C.D {
        @Override
        void methodD() {
            System.out.println("BBBB");
        }
    }
}

class C extends A {
    static class D {
        void methodD() {
            System.out.println("DDDD");
        }
    }

    @Override
    void methodA() {
        System.out.println("CCCC");
    }
}

