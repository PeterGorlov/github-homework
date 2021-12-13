package fortyFive;

class A {
    interface I {
        int i = 4444;

        void show(int i);
    }

    class B implements I {
        public void show(int i) {
            System.out.println(this.i);
        }
    }

    void methodA(int i) {
        new B().show(i);
    }
}

