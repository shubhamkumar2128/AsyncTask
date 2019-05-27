package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.lview)
    ListView lview;
    String data[] = {"aasd", "xcvz", "qweqw", "asdasd", "zxcz"
            , "qweq", "asdas", "xcvz", "qweqw", "asdasd",
            "zxcz", "qweq", "asdas", "xcvz", "qweqw",
            "asdasd", "zxcz", "qweq", "asdas", "xcvz",
            "asdasd", "zxcz", "qweq", "asdas", "xcvz"
            , "qweqw", "asdasd", "zxcz", "qweq", "asdas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        lview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new Task().execute();
    }

    class Task extends AsyncTask<Void, String, Void> {

        ArrayAdapter<String> arrayAdapter;

        @Override
        protected void onPreExecute() {
            arrayAdapter = (ArrayAdapter<String>) lview.getAdapter();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setProgressBarVisibility(false);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            arrayAdapter.add(values[0]);

        }

        @Override
        protected Void doInBackground(Void... params) {
            for (String item : data) {
                publishProgress(item);

            }
            return null;
        }
    }

}
