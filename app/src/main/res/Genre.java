import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Genre")
public class Genre extends Model {

    @Column(name = "GenreName")
    public String genreName;

    public Genre() {
        super();
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }
}
