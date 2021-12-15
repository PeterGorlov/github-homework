package fifth;

class A
{
    {
        new B();
    }

    static class B
    {
        {
            new A().new C();
        }
    }

    class C
    {
        {
            System.out.println("SUCCESS");
        }
    }
}

