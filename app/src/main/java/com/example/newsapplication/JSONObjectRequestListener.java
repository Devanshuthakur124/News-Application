package com.example.newsapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class JSONObjectRequestListener {

    private Context context;
    private RequestQueue requestQueue;

    public JSONObjectRequestListener(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public void fetchNews(String url, final NewsResponseCallback callback) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Success Response
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error Handling
                        Log.e("Volley Error", error.toString());
                        Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show();
                        callback.onError(error.toString());
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }

    // Callback Interface
    public interface NewsResponseCallback {
        void onSuccess(JSONObject response);
        void onError(String error);
    }
}