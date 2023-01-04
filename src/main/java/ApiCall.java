import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class ApiCall {

    private static final String CODE_URL = "https://www.random.org/integers/";

    public static String generateNonApiCode(int number, int max) {
        StringBuilder builder = new StringBuilder();

        Random random = new Random();
        int count = 0;
        while(count < number) {
            builder.append(random.nextInt(max + 1));
            count++;
        }

        return builder.toString();
    }

    public static String generateApiCode(int number, int max) {
        // define the parameters, or just hardcode the already known constants from instruction

        String parameters = "?num=" + number + "&min=0&max="
                + max + "&col=" + number
                + "&base=10&format=plain&rnd=new";


        try {

            URL url = new URL(CODE_URL + parameters);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line.trim());
            }

            bufferedReader.close();

            //replace extra spaces with "" and \t with ""
            return stringBuilder.toString().replace(" ", "").replace("\t", "");


        } catch (IOException e) {
            return generateNonApiCode(number, max);

        }
    }
}
