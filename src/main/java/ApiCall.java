import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCall {

    public static void main(String[] args) {
        System.out.println(generateCode(4, 8));
    }

    private static final String CODE_URL = "https://www.random.org/integers/";

    public static String generateCode(int number, int max) {
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

            //System.out.println(stringBuilder.toString());

            //replace extra spaces with "" and \t with ""
            return stringBuilder.toString().replace(" ", "").replace("\t", "");


        } catch (IOException e) {
            return null;
        }
    }
}
