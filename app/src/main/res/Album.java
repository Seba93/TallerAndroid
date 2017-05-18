import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Album")
public class Album extends Model {

    @Column(name = "AlbumName")
    public String albumName;

    @Column(name = "Band")
    public Band band;

    public Album() {
        super();
    }

    public Album(String albumName, Band band) {
        this.albumName = albumName;
        this.band = band;
    }
}