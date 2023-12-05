package algonquin.cst2335.deezerapiintegration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class FavoritesFragments extends Fragment {

    public List<Song> favoriteSongs;
    public ListView favoritesListView;
    public SongAdapter favoritesAdapter;

    public FavoritesFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        favoritesListView = view.findViewById(R.id.favoritesListView);

        // Initialize favoriteSongs list and populate it from the database
        favoriteSongs = fetchFavoriteSongs();

        // Initialize and set up the adapter
        favoritesAdapter = new FavoritesAdapter(getActivity(), favoriteSongs);
        favoritesListView.setAdapter(favoritesAdapter);

        // Handle item click in the favorites list
        favoritesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = favoriteSongs.get(position);
                // Handle displaying details of the selected song
                // (Possibly navigate to the details fragment/activity)
            }
        });

        return view;
    }

    // Method to fetch favorite songs from the database
    private List<Song> fetchFavoriteSongs() {
        List<Song> favorites = new ArrayList<>();
        // Retrieve favorite songs from the local database using DBHelper or Room
        // Add fetched songs to the favorites list
        return favorites;
    }
}
