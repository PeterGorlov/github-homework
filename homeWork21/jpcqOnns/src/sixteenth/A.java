package sixteenth;

class A
{
    void methodA1(int i)
    {
        System.out.println(i+++i);
    }

    void methodA2(int i)
    {
        System.out.println(--i-i--);
    }
}

class B
{
    A a = new A()
    {
        void methodA1(int i)
        {
            System.out.println(++i+i++);
        }

        void methodA2(int i)
        {
            System.out.println(i---i);
        }
    };
}

