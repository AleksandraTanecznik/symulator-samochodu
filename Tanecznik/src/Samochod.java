public class Samochod {
    private boolean silnikDziala = false;
    private int bieg = 0;
    private int predkosc = 0;
    private int obrotySilnika = 0;
    private int IloscWBaku = 55; // Maksymalna pojemność baku w litrach
    private int olejProcenty = 100; // Poziom oleju silnikowego w procentach

    public int getBieg()
    {
        return bieg;
    }

    public int getPredkosc()
    {
        return predkosc;
    }

    public int getObrotySilnika()
    {
        return obrotySilnika;
    }

    public int getBak()
    {
        return IloscWBaku;
    }

    public int getOlej()
    {
        return olejProcenty;
    }

    public void odpalSamochod()
    {
        if (!silnikDziala)
        {
            System.out.println("Samochód został odpalony. Silnik działa.");
            silnikDziala = true;
        }
        else
        {
            System.out.println("Samochód już chodzi.");
        }

    }

    public void zgasSamochod()
    {
        if(predkosc>0)
        {
            System.out.println("Nie można zgasić samochodu w trakcie jazdy");
        }
        else
        {
            if (silnikDziala)
            {
                System.out.println("Silnik został wyłączony. Samochód zgaszony");
                silnikDziala = false;
            }
            else
            {
                System.out.println("Samochód jest już zgaszony.");
            }
        }
    }

    public void zmienBieg(int nowyBieg)
    {
        if (silnikDziala)
        {
            if (nowyBieg>5)
            {
                System.out.println("Nie ma takiego biegu");
            }
            else
            {
                bieg = nowyBieg;
                System.out.println("Bieg zmieniony na " + nowyBieg + ".");
            }
        }
        else
        {
            System.out.println("Najpierw odpal samochód.");
        }
    }

    public void przyspiesz()
    {
        if (silnikDziala)
        {
            if (IloscWBaku > 0 && olejProcenty > 0)
            {
                predkosc += 10;
                obrotySilnika += 250;
                IloscWBaku--;
                olejProcenty--;
                System.out.println("Przyspieszono. Szybkość: " + predkosc + " km/h, Obroty silnika: " + obrotySilnika + ".");
            }
            else
            {
                System.out.println("Brak paliwa lub oleju. Nie można przyspieszyć.");
            }
        }
        else
        {
            System.out.println("Najpierw odpal samochów.");
        }
    }

    public void hamuj()
    {
        if (silnikDziala)
        {
            if (predkosc > 0)
            {
                predkosc -= 5;
                obrotySilnika -= 125;
                olejProcenty--;
                System.out.println("Hamowanie. Szybkość: " + predkosc + " km/h, Obroty silnika: " + obrotySilnika + ".");
                if (predkosc ==0)
                {
                    System.out.println("Samochód stoi.");
                }
            }
            else
            {
                System.out.println("Samochód stoi.");
            }
        } else {
            System.out.println("Najpierw odpal samochód.");
        }
    }

    public void wyswietlParametry() {
        System.out.println("Szybkość: " + predkosc + " km/h, Bieg: " + bieg + ", Obroty silnika: " + obrotySilnika + ".");
        System.out.println("Bak: " + IloscWBaku + " l, Olej silnikowy: " + olejProcenty + "%.");
    }

    public static void main(String[] args) {
        Samochod samochod = new Samochod();

        samochod.odpalSamochod();
        samochod.zmienBieg(1);
        samochod.przyspiesz();
        samochod.hamuj();
        samochod.wyswietlParametry();

        samochod.zmienBieg(7);

        samochod.zgasSamochod();
    }
}
