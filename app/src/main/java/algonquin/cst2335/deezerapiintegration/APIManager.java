package algonquin.cst2335.deezerapiintegration;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class APIManager {
    private RequestQueue requestQueue;
    private static APIManager instance;

    private APIManager(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized APIManager getInstance(Context context) {
        if (instance == null) {
            instance = new APIManager(context);
        }
        return instance;
    }

    public void searchArtist(String artistName, final OnSearchResultListener listener) {
        String url = "https://api.deezer.com/search/artist/?q=" + artistName;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle JSON response, parse data and pass it to listener
                        if (listener != null) {
                            listener.onSearchSuccess(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error response
                        if (listener != null) {
                            listener.onSearchFailure(error.getMessage());
                        }
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    // Interface for callbacks on search result
    public interface OnSearchResultListener {
        void onSearchSuccess(JSONObject response);
        void onSearchFailure(String errorMessage);
    }
}