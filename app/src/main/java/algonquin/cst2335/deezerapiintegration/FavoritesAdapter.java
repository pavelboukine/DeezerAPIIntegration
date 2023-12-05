package algonquin.cst2335.deezerapiintegration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class FavoritesAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> favoritesList;

    public FavoritesAdapter(Context context, ArrayList<String> favoritesList) {
        super(context, R.layout.item_favorite, favoritesList);
        this.context = context;
        this.favoritesList = favoritesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        // ViewHolder pattern for efficient list item reuse
        ViewHolder viewHolder;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.item_favorite, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textViewFavoriteItem = rowView.findViewById(R.id.textViewFavoriteItem);

            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        // Set data to the views
        viewHolder.textViewFavoriteItem.setText(favoritesList.get(position));

        return rowView;
    }

    // ViewHolder to hold references to views for efficient recycling
    static class ViewHolder {
        TextView textViewFavoriteItem;
    }
}
