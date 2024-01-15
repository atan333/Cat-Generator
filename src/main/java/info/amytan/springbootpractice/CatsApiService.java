package info.amytan.springbootpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CatsApiService {
    private static RestTemplate restTemp = null;
    private static final String url = "https://api.thecatapi.com/v1/images/search";

    public CatsApiService(RestTemplate restTemplate) {
        restTemp = restTemplate;
    }

    public static String getCatImage() {
        CatImage[] response = restTemp.getForObject(url, CatImage[].class);
        CatImage firstImage = response[0];
        String catUrl = null;
        try {
            log.info("Calling Cats API...");
            if (firstImage != null) {
                catUrl = firstImage.getUrl();
                int width = firstImage.getWidth();
                int height = firstImage.getHeight();
                log.info("Received data from Cats API");
                return "<img src=\"" + catUrl + "\" width=\"" + width + "\" height=\"" + height + "\">";
            } else {
                log.warn("Received null data from Cats API");
            }
        } catch (Exception e) {
            log.error("Error occurred when calling Cats API");
            throw e;
        }
        return null;
    }

}
