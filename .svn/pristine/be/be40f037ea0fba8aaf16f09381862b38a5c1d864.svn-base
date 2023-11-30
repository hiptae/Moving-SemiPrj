package kr.co.mpago.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lombok.extern.log4j.Log4j;

@Log4j
public class MovieJsonDataFetcher {
	
	/**
	 * JSON 데이터를 가져옴
	 * @param apiUrl
	 * 
	 * 
	 * @return jsonMovieData
	 * @throws IOException
	 */
	public String fetchJsonData(String apiUrl) throws IOException {
		URL url = new URL(apiUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            log.info("fetchJsonData()_OK");
            return response.toString();
        } else {
        	log.info("fetchJsonData()_failed");
            return null;
        }
	}
}
