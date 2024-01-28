public class Paliwo {
    private int IloscWBaku = 55; // Maksymalna pojemność baku w litrach

    public int getBak()
    {
        return IloscWBaku;
    }
    public void setIloscWBaku(int b) { this.IloscWBaku -= b;}
}
