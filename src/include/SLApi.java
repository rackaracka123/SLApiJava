package include;

import kong.unirest.*;

import java.util.ArrayList;

public class SLApi {
    ArrayList<APIKey> apiKeys;

    public SLApi(ArrayList<APIKey> apiKeys) {
        this.apiKeys = new ArrayList<>(apiKeys);
    }
    private APIKey getPlatsFromList(){
        for (APIKey api : apiKeys){
            if (api.getBase() == "https://api.sl.se/api2/typeahead.")
                return api;
        }
        return null;
    }
    private APIKey getRealtidsInformation(){
        for (APIKey api : apiKeys){
            if (api.getBase() == "https://api.sl.se/api2/realtimedeparturesV4.")
                return api;
        }
        return null;
    }
    public HttpResponse<JsonNode> getSLPlatsupplsag(String searchStr){
        return Unirest.get("https://api.sl.se/api2/typeahead.<FORMAT>?key=<DIN NYCKEL>&searchstring=<SÖKORD>&stationsonly=<ENDAST STATIONER>&maxresults=<MAX ANTAL SVAR>")
                .header("x-apikey", getPlatsFromList().getApikey())
                .header("", "")
                .header("siteid", "1234")
                .header("Content-Type", "application/json")
                .asJson();
    }
    public HttpResponse<JsonNode> getSLRealtidsInformation(String searchStr){
        return Unirest.get("https://api.sl.se/api2/realtimedeparturesV4.<FORMAT>?key=<DIN API NYCKEL>&siteid=<SITEID>&timewindow=<TIMEWINDOW>")
                .header("x-apikey", getPlatsFromList().getApikey())
                .header("", "")
                .header("siteid", "1234")
                .header("Content-Type", "application/json")
                .asJson();
    }
}
