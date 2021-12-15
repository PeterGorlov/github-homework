package tenth;

class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }
        }
    }

    void methodThree()
    {
//        new B().methodTwo();
//        Локальные внутренние классы не видны вне метода или блока, в котором он определен.
    }
}
