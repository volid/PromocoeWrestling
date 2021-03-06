package com.example.valterpereira.promocoewrestling;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.valterpereira.promocoewrestling.model.Cash;
import com.example.valterpereira.promocoewrestling.model.Promocao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends ListFragment {
    static CustomAdapter customAdapter;
    private OnTitleSelectedListener mCallback;
    public TitlesFragment()
    {
        // Required empty public constructor
    }
    public interface OnTitleSelectedListener {
        void OnDetailsSelected(int position, Promocao promocoes, CustomAdapter customAdapter);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnTitleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Wrestling Português");
        customAdapter = new CustomAdapter(getActivity().getBaseContext(), Cash.getList());
        setListAdapter(customAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();

        FetchAsyncTask fetchAsyncTask = new FetchAsyncTask();
        fetchAsyncTask.execute(MainActivity.RESOURCE);
    }
    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {

        mCallback.OnDetailsSelected(position, customAdapter.getItem(position), customAdapter);


    }



    private class FetchAsyncTask extends AsyncTask<String, Void, List<Promocao>> {

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Promocao> doInBackground(String... strings) {
            List<Promocao> promocoes = new ArrayList<>();

            if (null != strings[0]) {
                String urlString = strings[0];
                try {
                    JSONArray jsonArray = new JSONArray(urlString);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String name = jsonObject.optString("Name", "");
                        String description = jsonObject.optString("Description", "");
                        String image = jsonObject.optString("Image", "");
                        String website = jsonObject.optString("Website", "");
                        String location = jsonObject.optString("Location", "");
                        Promocao promocao = new Promocao(name, description, image, website, location);
                        promocoes.add(promocao);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            return promocoes;
        }

        @Override
        protected void onPostExecute(List<Promocao> promocoes) {
            Cash.setList(promocoes);
            customAdapter.updatePromocoes(promocoes);
        }
    }
    }
