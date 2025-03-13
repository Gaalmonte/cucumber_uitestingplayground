package hellocucumber;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JSONReader {
    private JsonNode rootNode;

    public JSONReader(String jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            rootNode = mapper.readTree(new File(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocator(String pageName, String fieldName){
        JsonNode pageNode = rootNode.path(pageName);
        return pageNode.path(fieldName).asText();
    }
}
