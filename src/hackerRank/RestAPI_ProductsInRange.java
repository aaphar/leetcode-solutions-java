//package hackerRank;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//
//import java.net.URL;
//
//public class RestAPI_ProductsInRange {
//    public static int getProductsInRange(String category, int minPrice, int maxPrice)
//    {
//        int page = 1;
//        int totalPage=1;
//        int count = 0;
//
//        try {
//            while (page<=totalPage) {
//                String urlString = "https://jsonmock.hackerrank.com/api/inventory?category=" + category + "&page=" + page;
//                URL url = new URL(urlString);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//
//                StringBuilder response = new StringBuilder();
//                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                    String responseLine;
//                    while ((responseLine = br.readLine()) != null) {
//                        response.append(responseLine.trim());
//                    }
//                }
//
//                String responseString = response.toString();
//                JSONObject json = new JSONObject(responseString);
//                totalPage = json.getInt("total_pages");
//
//                JSONArray data = json.getJSONArray("data");
//                for (int i = 0; i < data.length(); i++) {
//                    JSONObject product = data.getJSONObject(i);
//                    int price = product.getInt("price");
//
//                    if (price >= minPrice && price <= maxPrice) {
//                        count++;
//                    }
//                }
//                page++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return count;
//
//    }
//}
