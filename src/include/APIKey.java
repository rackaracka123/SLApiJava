package include;

public class APIKey {
    private String apikey;
    private String base;
    public APIKey(String key, String base){
        apikey = key;
        this.base = base;
    }
    public String getApikey() {
        return apikey;
    }

    public String getBase() {
        return base;
    }
}
