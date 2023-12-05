package algonquin.cst2335.deezerapiintegration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView durationTextView;
        // Other views for album name, album cover, etc.

        SongViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            durationTextView = itemView.findViewById(R.id.durationTextView);
            // Initialize other views
        }
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.titleTextView.setText(song.getTitle());
        holder.durationTextView.setText(song.getDuration());
        // Set other data to views (album name, album cover, etc.)

        // Implement click listener for the item
        holder.itemView.setOnClickListener(v -> {
            // Handle item click (e.g., navigate to song details screen)
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    // Method to update the song list when data changes
    public void updateList(List<Song> newList) {
        songList = newList;
        notifyDataSetChanged();
    }
}
