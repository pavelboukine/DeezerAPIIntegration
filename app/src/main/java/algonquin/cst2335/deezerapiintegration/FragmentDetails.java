package algonquin.cst2335.deezerapiintegration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;

public class FragmentDetails extends Fragment {

    private Song selectedSong;

    public FragmentDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the selected song from arguments or ViewModel
        if (getArguments() != null) {
            selectedSong = getArguments().getParcelable("selected_song");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView durationTextView = view.findViewById(R.id.durationTextView);
        TextView albumNameTextView = view.findViewById(R.id.albumNameTextView);
        ImageView albumCoverImageView = view.findViewById(R.id.albumCoverImageView);

        if (selectedSong != null) {
            titleTextView.setText(selectedSong.getTitle());
            durationTextView.setText(selectedSong.getDuration());
            albumNameTextView.setText(selectedSong.getAlbumName());
            // Load album cover using Glide or any other image loading library
            Glide.with(this).load(selectedSong.getAlbumCover()).into(albumCoverImageView);
        }

        return view;
    }
}


