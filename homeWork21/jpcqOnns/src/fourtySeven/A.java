package fourtySeven;

class A {
    static {
        System.out.println(1);

        class B {
            {
                System.out.println(2);
            }
        }
    }

    {
        System.out.println(3);

        class B {
            {
                System.out.println(4);
            }
        }
    }
}

