import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {

    // Helper to fetch rates from ExchangeRate-API
    private static JsonObject fetchRates(String baseCurrency) throws Exception {
        String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency;
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("API request failed: HTTP " + conn.getResponseCode());
        }

        JsonElement root = JsonParser.parseReader(new InputStreamReader(conn.getInputStream()));
        return root.getAsJsonObject();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Real-Time Currency Converter");
        System.out.print("Enter base currency (e.g. USD): ");
        String base = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g. INR): ");
        String target = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            JsonObject data = fetchRates(base);
            JsonObject rates = data.getAsJsonObject("rates");

            if (!rates.has(target)) {
                System.out.println("❌ Currency not supported by API.");
            } else {
                double rate = rates.get(target).getAsDouble();
                double converted = amount * rate;
                System.out.printf("✅ %.2f %s = %.2f %s (Rate: 1 %s = %.4f %s)\n",
                        amount, base, converted, target, base, rate, target);
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to fetch exchange rates: " + e.getMessage());
        }

        scanner.close();
    }
}
