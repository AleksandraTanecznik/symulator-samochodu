public class SkrzyniaBiegow {
    private int bieg = 0;
    public int getBieg() { return bieg;}

    public boolean biegWyzej()
    {
        if (bieg < 5) {
            bieg++;
            return true;
        }
        return false;
    }

    public boolean biegNizej()
    {
        if (bieg > 0)
        {
            bieg--;
            return true;
        }
        return false;
    }

}
