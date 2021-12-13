package thirteenth;

class ABC
{
    int i = 10101;

    {
        i--;
    }

    public ABC()
    {
        --i;
    }

    class XYZ
    {
        int i = this.i;

        {
            i++;
        }

        public XYZ()
        {
            ++i;
        }
    }
}

