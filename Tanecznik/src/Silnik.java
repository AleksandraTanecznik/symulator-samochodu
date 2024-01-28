public class Silnik {
    private boolean silnikDziala = false;
    private int predkosc = 0;
    private int obrotySilnika = 0;

    public boolean getCzyDziala(){ return silnikDziala;}
    public int getPredkosc()
    {
        return predkosc;
    }
    public void setPredkosc(int p) { this.predkosc += p;}

    public int getObrotySilnika()
    {
        return obrotySilnika;
    }
    public void setObrotySilnika(int o) { this.obrotySilnika += o;}

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

    public void przyspiesz()
    {
        if (!silnikDziala)
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
}
