import java.util.*;
import java.util.stream.Collectors;

class Country{
    String country;
    List<String> languages;

    public Country(String country, List<String> languages){
        this.country = country;
        this.languages = languages;
    }

    public String getCountry(){return this.country;}
    public void setCountry(String country){this.country=country;}
    public List<String> getLanguages(){return this.languages;}
    public void setLanguages(List<String> languages){this.languages=languages;}
}

public class ExerciseTwo {

    public static void main(String[] args) {

        Country country1 = new Country("Brasil", Arrays.asList("portuguese"));
        Country country2 = new Country("Netherlands", Arrays.asList("english", "de", "french"));
        Country country3 = new Country("France", Arrays.asList("english", "french"));


        List<Country> countries = new ArrayList<>(Arrays.asList(country1, country2, country3));

        short amountOfCountries = amountOfCountries(countries);
        System.out.println(amountOfCountries);

        Country highest = highestCountry(countries);
        System.out.println(highest.getCountry());

        short amountOfLanguages = amountOfLanguages(countries);
        System.out.println(amountOfLanguages);

        Map<String, Integer> mostCommonOfficialLanguages = mostCommonOfficialLanguages(countries);
        System.out.println(mostCommonOfficialLanguages);
    }

    private static Country highestCountry(List<Country> countries) {
        Country highest = countries.get(0);
        for (Country country: countries) {
            if(Objects.nonNull(country) && country.getLanguages().size() > highest.getLanguages().size()){
                highest = country;
            }
        }
        return highest;
    }

    private static short amountOfLanguages(List<Country> countries){
        Set<String> languages = new HashSet<>();
        for (Country country:countries) {
            languages.addAll(country.getLanguages());
        }
        return (short) languages.size();
    }

    private static short amountOfCountries(List<Country> countries){
        return (short) countries.stream()
                .filter(country -> Objects.nonNull(country) && !country.getCountry().isBlank())
                .collect(Collectors.toSet())
                .size();
    }

    private static Map<String, Integer> mostCommonOfficialLanguages(List<Country> countries){
        Map<String, Integer> languages = new HashMap<>();
        for (Country country:countries) {
            for (String language:country.getLanguages()) {
                if(languages.containsKey(language)){
                    Integer newCount = languages.get(language) + 1;
                    languages.put(language, newCount);
                }else{
                    languages.put(language, 1);
                }
            }
        }
        return languages;
    }

}
