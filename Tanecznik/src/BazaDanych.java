import java.sql.*;

public class BazaDanych {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/stan_samochodu";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Metoda do zapisywania stanu paliwa i oleju do bazy danych MySQL
    public static void zapiszStan(int poziomPaliwa, int poziomOleju) {
        try
        {

            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String query = "INSERT INTO stan_samochodu (poziom_paliwa, poziom_oleju) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                preparedStatement.setInt(1, poziomPaliwa);
                preparedStatement.setInt(2, poziomOleju);
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static Olej pobierzStanOleju() {
        Olej olej = new Olej();

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String query = "SELECT poziom_oleju FROM stan_samochodu ORDER BY id DESC LIMIT 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {
                    olej.setOlejProcenty(resultSet.getInt("poziom_oleju"));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return olej;
    }

    public static Paliwo pobierzStanPaliwa() {
        Paliwo paliwo = new Paliwo();

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String query = "SELECT poziom_paliwa FROM stan_samochodu ORDER BY id DESC LIMIT 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {
                    paliwo.setIloscWBaku(resultSet.getInt("poziom_paliwa"));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paliwo;
    }
}
