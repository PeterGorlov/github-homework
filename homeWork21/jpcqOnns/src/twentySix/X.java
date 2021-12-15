package twentySix;

class X
{
    int x = 111;

    static class Y extends X
    {
        int y = x + 222;
    }

    class Z extends X.Y
    {
        int z = y + 333;
    }
}

