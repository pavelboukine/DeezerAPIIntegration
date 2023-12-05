package algonquin.cst2335.deezerapiintegration;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SongDB";
    private static final String TABLE_FAVORITES = "favorites";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    // Add other columns as needed

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FAVORITES_TABLE = "CREATE TABLE " + TABLE_FAVORITES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT)";
        db.execSQL(CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
        onCreate(db);
    }

    public void addFavorite(Song song) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, song.getTitle());
        // Add other values

        db.insert(TABLE_FAVORITES, null, values);
        db.close();
    }

    public void deleteFavorite(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITES, KEY_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Song> getAllFavorites() {
        List<Song> favoritesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVORITES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Song song = new Song();
                song.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                song.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                // Retrieve other columns and set values

                favoritesList.add(song);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return favoritesList;
    }

    // Add other methods as needed for database operations
}
