package thirty;

class X {
    static {
        class Y {
            {
                System.out.println(1);
            }
        }
    }

    {
        class Y {
            {
                System.out.println(2);
            }
        }
    }
}

