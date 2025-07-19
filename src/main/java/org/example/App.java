package org.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("#########################################");
        System.out.println("###   Real-Time Currency Converter    ###");
        System.out.println("#########################################");
        System.out.print("\nEnter your API Key from ExchangeRate-API: ");
        String apiKey = scanner.nextLine();

        try {
            // --- Get Conversion Details from User ---
            System.out.print("Enter the amount to convert: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the leftover newline character

            System.out.print("Enter the source currency code (e.g., USD, EUR): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter the target currency code (e.g., INR, JPY): ");
            String toCurrency = scanner.nextLine().toUpperCase();

            // --- Perform the Conversion ---
            convertCurrency(apiKey, fromCurrency, toCurrency, amount);

        } catch (java.util.InputMismatchException e) {
            System.err.println("\nError: Invalid amount entered. Please enter a numeric value.");
        } catch (IOException e) {
            System.err.println("\nError: Network connection issue or invalid API URL.");
            System.err.println("Details: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nAn unexpected error occurred. Please try again.");
            System.err.println("Details: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nThank you for using the Currency Converter!");
        }
    }

    private static void convertCurrency(String apiKey, String fromCurrency, String toCurrency, double amount) throws IOException {
        // Construct the API request URL
        String urlString = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + fromCurrency;
        URL url = new URL(urlString);

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { // Success
            // Read the JSON response from the API
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(reader, JsonObject.class);
            reader.close();

            // Check if the API request was successful
            if ("success".equals(jsonResponse.get("result").getAsString())) {
                JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

                // Check if the target currency code is valid
                if (rates.has(toCurrency)) {
                    double exchangeRate = rates.get(toCurrency).getAsDouble();
                    double convertedAmount = amount * exchangeRate;

                    // --- Display the final result ---
                    System.out.println("\n---------- Result ----------");
                    System.out.printf("✅ %,.2f %s = %,.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
                    System.out.println("----------------------------");

                } else {
                    System.err.println("\nError: Invalid target currency code '" + toCurrency + "'.");
                }
            } else {
                // Handle API-specific errors (e.g., invalid key, unsupported code)
                String errorType = jsonResponse.get("error-type").getAsString();
                System.err.println("\nAPI Error: " + errorType);
                System.err.println("Please check your API key or ensure the currency codes are supported.");
            }

        } else {
            // Handle HTTP errors
            System.err.println("\nError: Failed to get data from API. HTTP Response Code: " + responseCode);
            System.err.println("Possible issues: Invalid API key, network problems, or the API service is down.");
        }
        connection.disconnect();
    }

}
