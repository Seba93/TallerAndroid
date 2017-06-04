package com.example.tallerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.activeandroid.query.Delete;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String BAND_ID = "com.example.tallerandroid.BAND_ID";
    public static final String BAND_NAME = "com.example.tallerandroid.BAND_NAME";
    public static final String BAND_COUNTRY = "com.example.tallerandroid.BAND_COUNTRY";
    public static final String BAND_GENRE = "com.example.tallerandroid.BAND_GENRE";
    public static final String ORIGIN_YEAR = "com.example.tallerandroid.ORIGIN_YEAR";

    @Override
    //Create view elements
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Clear database
        new Delete().from(Song.class).execute();
        new Delete().from(Album.class).execute();
        new Delete().from(Band.class).execute();
        new Delete().from(Song.class).execute();
        new Delete().from(Genre.class).execute();
        new Delete().from(Country.class).execute();

        // Add rows to each database table
        this.insertData();

        // Find the listView Resource
        ListView listView = (ListView) findViewById(R.id.listView);

        // Get list of bands
        ArrayList<Band> bands = Band.getAll();

        // Get the name of each existing band
        //ArrayList<String> bandsNames = new ArrayList<>();
        //for (Band band : bands) {
        //    bandsNames.add(band.getBandName());
        //}

        // Create ArrayAdapter using the bands list
        ArrayAdapter<Band> bandsListAdapter = new ArrayAdapter<>(this, R.layout.list_view_row, bands);

        // Set the ArrayAdapter as the ListView's adapter.
        listView.setAdapter(bandsListAdapter);

        // On listView item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Band band = (Band) adapter.getItemAtPosition(position);
                showBandInfo(band);
            }
        });
    }

    // To display info of a given band
    public void showBandInfo(Band band) {
        // Get a band and send data to DisplayBandInfoActivity (Activit)
        Intent intent = new Intent(this, DisplayBandInfoActivity.class);

        // Send data to DisplayBandInfoActivity
        intent.putExtra(BAND_ID, String.valueOf(band.getId()));
        intent.putExtra(BAND_NAME, band.getBandName());
        intent.putExtra(BAND_COUNTRY, band.getCountry().getCountryName());
        intent.putExtra(BAND_GENRE, band.getGenre().getGenreName());
        intent.putExtra(ORIGIN_YEAR, String.valueOf(band.getOriginYear()));
        startActivity(intent);
    }

    protected void insertData() {
        // Add countries to database
        Country USA = new Country("USA");
        Country England = new Country("England");
        Country Germany = new Country("Germany");
        Country Sweden = new Country("Sweden");

        // Add genres to database
        Genre heavyMetal = new Genre("Heavy Metal");
        Genre progressiveMetal = new Genre("Progressive Metal");
        Genre thrashMetal = new Genre("Thrash Metal");

        // Add bands to database
        Band ironMaiden = new Band("Iron Maiden", England, heavyMetal, 1975);
        Band judasPriest = new Band("Judas Priest", England, heavyMetal, 1970);
        Band saxon = new Band("Saxon", England, heavyMetal, 1977);
        Band dreamTheater = new Band("Dream Theater", USA, progressiveMetal, 1985);
        Band megadeth = new Band("Megadeth", USA, thrashMetal, 1983);
        Band slayer = new Band ("Slayer", USA, thrashMetal, 1981);
        Band accept = new Band("Accept", Germany, heavyMetal, 1968);
        Band opeth = new Band("Opeth", Sweden, progressiveMetal, 1989);

        // Add albums to database
        Album killers = new Album("Killers", ironMaiden, 1981);
        Album powerslave = new Album("Powerslave", ironMaiden, 1984);
        Album painkiller = new Album("Painkiller", judasPriest, 1990);
        Album jugulator = new Album("Jugulator", judasPriest, 1997);
        Album crusader = new Album("Crusader", saxon, 1984);
        Album sacrifice = new Album("Sacrifice", saxon, 2013);
        Album awake = new Album("Awake", dreamTheater, 1994);
        Album octavarium = new Album("Octavarium", dreamTheater, 2005);
        Album youthanasia = new Album("Youthanasia", megadeth, 1994);
        Album risk = new Album("Risk", megadeth, 1999);
        Album showNoMercy = new Album("Show No Mercy", slayer, 1983);
        Album repentless = new Album("Repentless", slayer, 2015);
        Album breaker = new Album("Breaker", accept, 1981);
        Album stalingrad = new Album("Stalingrad", accept, 2012);
        Album orchid = new Album("Orchid", opeth, 1995);
        Album sorceress = new Album("Sorceress", opeth, 2016);

        // Add songs to database
        Song wrathchild = new Song("Wrathchild", killers, 1);
        Song gengisKhan = new Song ("Gengis Khan", killers, 2);
        Song prodigalSon = new Song("Prodigal Son", killers, 3);
        Song purgatory = new Song("Purgatory", killers, 4);
        Song drifter = new Song("Drifter", killers, 5);
        Song acesHigh = new Song("Aces High", powerslave, 1);
        Song tmtm = new Song("2 Minutes To Midnight", powerslave, 2);
        Song fotb = new Song ("Flash Of The Blade", powerslave, 3);
        Song duellists = new Song("The Duellists", powerslave, 4);
        Song hellPatrol = new Song("Hell Patrol", painkiller, 1);
        Song agb = new Song("All Guns Blazing", painkiller, 2);
        Song leatherRebel = new Song("Leather Rebel", painkiller, 3);
        Song metalMeltdown = new Song("Metal Meltdown", painkiller, 4);
        Song bloodStained = new Song("Blood Stained", jugulator, 1);
        Song decapited = new Song("Decapited", jugulator, 2);
        Song burnInHell = new Song("Burn In Hell", jugulator, 3);
        Song sta = new Song("Sailing To America", crusader, 1);
        Song setMeFree = new Song("Set Me Free", crusader, 2);
        Song rockCity = new Song("Rock City", crusader, 3);
        Song badBoys = new Song("Bad Boys", crusader, 4);
        Song procession = new Song("Procession", sacrifice, 1);
        Song madeInBelfast = new Song("Made In Belfast", sacrifice, 2);
        Song wts = new Song("Walking The Steel", sacrifice, 3);
        Song notw = new Song("Night Of The Wolf", sacrifice, 4);
        Song soc = new Song("6:00", awake, 1);
        Song erotomania = new Song("Erotomania", awake, 2);
        Song voices = new Song("Voices", awake, 3);
        Song tsm = new Song("The Silent Man", awake, 4);
        Song theMirror = new Song("The Mirror", awake, 5);
        Song panicAttack = new Song("Panic Attack", octavarium, 1);
        Song theseWalls = new Song("These Walls", octavarium, 2);
        Song neverEnough = new Song("Never Enough", octavarium, 3);
        Song sacrificedSons = new Song("Sacrificed Sons", octavarium, 4);
        Song reckDay = new Song("Reckoning Day", youthanasia, 1);
        Song atc = new Song("Addicted To Chaos", youthanasia, 2);
        Song atlm = new Song("A Tout Le Monde", youthanasia, 3);
        Song elysianFields = new Song("Elysian Fields", youthanasia, 4);
        Song familyTree = new Song("Family Tree", youthanasia, 5);
        Song insomnia = new Song("Insomnia", risk, 1);
        Song breadline = new Song("Breadline", risk, 2);
        Song wanderlust = new Song("Wanderlust", risk, 3);
        Song ecstasy = new Song ("Ecstasy", risk, 4);
        Song dbts = new Song ("Die By The Sword", showNoMercy, 1);
        Song metalstorm = new Song ("Metalstorm", showNoMercy, 2);
        Song blackMagic = new Song ("Black Magic", showNoMercy, 3);
        Song tormentor = new Song ("Tormentor", showNoMercy, 4);
        Song crionics = new Song ("Crionics", showNoMercy, 5);
        Song takeControl = new Song ("Take Control", repentless, 1);
        Song vices = new Song("Vices", repentless, 2);
        Song chasingDeath = new Song ("Chasing Death", repentless, 3);
        Song implode = new Song("Implode", repentless, 4);
        Song starlight = new Song ("Starlight", breaker, 1);
        Song burning = new Song ("Burning", breaker, 2);
        Song feelings = new Song("Feelings", breaker, 3);
        Song midnightHighway = new Song ("MidnightHighway", breaker, 4);
        Song hellfire = new Song ("Hellfire", stalingrad, 1);
        Song revolution = new Song ("Revolution", stalingrad, 2);
        Song neverForget = new Song("Never Forget", stalingrad, 3);
        Song theGalley = new Song("The Galley", stalingrad, 4);
        Song shadowSoldiers = new Song("Shadow Soldiers", stalingrad, 5);
        Song utwm = new Song("Under The Weeping Moon", orchid, 1);
        Song silhouette = new Song("Silhouette", orchid, 2);
        Song foo = new Song("Forest Of October", orchid, 3);
        Song requiem = new Song("Requiem", orchid, 4);
        Song persephone = new Song("Persephone", sorceress, 1);
        Song chrysalis = new Song("Chrysalis", sorceress, 2);
        Song  era = new Song("Eera", sorceress, 3);
        Song theWard = new Song("The Ward", sorceress, 4);
    }

    @Override
    protected void onPause() {super.onPause();}

    @Override
    protected void onResume() {super.onResume();}

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}