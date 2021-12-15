package thirtyTwo;

class A
{
    abstract class B
    {
        abstract void method();
    }

    {
        new B()
        {

            @Override
            void method()
            {
                System.out.println("BBB");
            }
        }.method();
    }
}

