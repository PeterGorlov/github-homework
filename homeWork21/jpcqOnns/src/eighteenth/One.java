package eighteenth;

class One
{
    {
        System.out.println("ONE");
    }

    class Two
    {
        {
            System.out.println("TWO");
        }
    }

    static
    {
        System.out.println("THREE");
    }

    static class Three
    {
        {
            System.out.println("FOUR");
        }

        static
        {
            System.out.println("FIVE");
        }
    }
}

