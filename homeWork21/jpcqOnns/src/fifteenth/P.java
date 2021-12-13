package fifteenth;

class P
{
    String s = "PPP";

    {
        System.out.println(s);
    }

    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";

            {
                System.out.println(s);
            }
        }

        return new Q().s+s;
    }
}

