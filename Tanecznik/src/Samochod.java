public class Samochod {
    private Silnik silnik;
    private SkrzyniaBiegow skrzyniaBiegow;
    private Paliwo paliwo;
    private Olej olej;
    private int predkosc;

    public Samochod() {
        silnik = new Silnik();
        skrzyniaBiegow = new SkrzyniaBiegow();
        paliwo = new Paliwo();
        olej = new Olej();
        silnik.getPredkosc();
    }

    public int getPredkosc(){return silnik.getPredkosc();}
    public int getObrotySilnika(){return silnik.getObrotySilnika();}
    public int getBak(){return paliwo.getBak();}
    public int getOlej(){return olej.getOlej();}
    public int getBieg(){return  skrzyniaBiegow.getBieg();}

    public void odpalSamochod() { silnik.odpalSamochod();}

    public void zgasSamochod() { silnik.zgasSamochod();}


    public void przyspiesz()
    {
        silnik.przyspiesz();
        if(silnik.getCzyDziala())
        {
            if(skrzyniaBiegow.getBieg()!=0)
            {
                if (getBak() > 0 && getOlej() > 0 )
                {
                    if(getPredkosc()>=150)
                    {
                        System.out.println("Nie można bardziej przyspieszyć");
                    }
                    else
                    {
                        silnik.setPredkosc(10);
                        silnik.setObrotySilnika(250);
                        paliwo.setIloscWBaku(1);
                        olej.setOlejProcenty(1);
                        System.out.println("Przyspieszono. Szybkość: " + getPredkosc() + " km/h, Obroty silnika: " + getObrotySilnika() + ".");
                    }
                }
                else
                {
                    System.out.println("Brak paliwa lub oleju. Nie można przyspieszyć.");
                }
            }
            else
            {
                System.out.println("Nie moża przyspieszyć na biegu 0. Zmień bieg na wyższy");
            }
        }
    }
    public void hamuj() { silnik.hamuj();}

    public void biegWyzej()
    {
        if (silnik.getCzyDziala())
        {
            skrzyniaBiegow.biegWyzej();
        }
        else
        {
            System.out.println("Najpierw odpal samochów.");
        }
    }
    public void biegNizej()
    {
        if (silnik.getCzyDziala())
        {
            skrzyniaBiegow.biegNizej();
        }
        else
        {
            System.out.println("Najpierw odpal samochów.");
        }
    }

    public void zapiszStan() {
        BazaDanych.zapiszStan(getBak(), getOlej());
}






















//    public void wyswietlParametry() {
//        System.out.println("Szybkość: " + predkosc + " km/h, Bieg: " + bieg + ", Obroty silnika: " + obrotySilnika + ".");
//        System.out.println("Bak: " + IloscWBaku + " l, Olej silnikowy: " + olejProcenty + "%.");
//    }

    public static void main(String[] args) {
        Samochod samochod = new Samochod();


    }
}
