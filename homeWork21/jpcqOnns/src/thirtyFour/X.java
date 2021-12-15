package thirtyFour;

class X {
    {
        class Y {
            {
                System.out.println(1);
            }
        }

        new Y();
    }

    static {
        class Z {
            {
                System.out.println(2);
            }
        }

        new Z();
    }
}

