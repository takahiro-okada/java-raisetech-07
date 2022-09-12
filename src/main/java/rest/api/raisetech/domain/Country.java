package rest.api.raisetech.domain;

public class Country {
    private final Integer countryCode;
    private final String countryName;

    public long getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public Country(Integer countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }
}

