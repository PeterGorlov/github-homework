package twentyNine;

class A {
    {
        System.out.println(1);
    }

    void method() {
        class B {
            {
                System.out.println(2);
            }

            class C {
                {
                    System.out.println(3);
                }
            }
        }
    }
}

