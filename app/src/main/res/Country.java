import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Country")
public class Country extends Model {

    @Column(name = "CountryName")
    public String countryName;

    public Country() {
        super();
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }
}
