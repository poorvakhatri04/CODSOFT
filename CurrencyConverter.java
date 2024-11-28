import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    // Method to fetch the exchange rate from the API
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String apiUrl = "https://data.fixer.io/api/latest?access_key=73231e1114b8c119782203852dcd11c2";
        double exchangeRate = 0.0;

        try {
            // Establishing connection to the API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Reading response
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parsing JSON response to extract exchange rates
                String jsonResponse = response.toString();
                if (jsonResponse.contains("\"rates\"")) {
                    // Extract base rate
                    double baseRate = 1.0;
                    if (!baseCurrency.equalsIgnoreCase("EUR")) {
                        String[] splitBase = jsonResponse.split("\"" + baseCurrency + "\":");
                        baseRate = Double.parseDouble(splitBase[1].split(",")[0].replaceAll("[^\\d.]", ""));
                    }

                    // Extract target rate
                    String[] splitTarget = jsonResponse.split("\"" + targetCurrency + "\":");
                    double targetRate = Double.parseDouble(splitTarget[1].split(",")[0].replaceAll("[^\\d.]", ""));

                    // Calculate exchange rate relative to the base currency
                    exchangeRate = targetRate / baseRate;
                } else {
                    System.out.println("Error: 'rates' field not found in the API response.");
                }
            } else {
                System.out.println("Error: Unable to fetch exchange rate. Response code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return exchangeRate;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Currency Selection
        System.out.print("Enter the base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., INR, JPY): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Step 2: Input Amount
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Step 3: Fetch Exchange Rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != 0.0) {
            // Step 4: Perform Conversion
            double convertedAmount = amount * exchangeRate;

            // Step 5: Display Result
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Conversion failed. Please try again.");
        }

        scanner.close();
    }
}