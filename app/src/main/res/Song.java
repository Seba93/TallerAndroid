import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by seba on 17-05-17.
 */

@Table(name="Song")
public class Song extends Model {

    @Column(name = "SongName")
    public String songName;

    @Column(name = "Album")
    public Album album;

    public Song() {
        super();
    }

    public Song(String songName, Album album) {
        this.songName = songName;
        this.album = album;
    }
}
