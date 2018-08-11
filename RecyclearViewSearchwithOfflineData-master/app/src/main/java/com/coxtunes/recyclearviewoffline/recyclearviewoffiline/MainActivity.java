package com.coxtunes.recyclearviewoffline.recyclearviewoffiline;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<model> flaglist;

    adapter myadapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.listshow);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        flaglist = new ArrayList<>();

        flaglist.add(new model("Bangladesh",R.drawable.bangladesh));
        flaglist.add(new model("Brazil",R.drawable.brazil));
        flaglist.add(new model("China",R.drawable.china));
        flaglist.add(new model("India",R.drawable.india));
        flaglist.add(new model("Indonesia",R.drawable.indonesia));
        flaglist.add(new model("Japan",R.drawable.japan));
        flaglist.add(new model("Nigeria",R.drawable.nigeria));
        flaglist.add(new model("Pakistan",R.drawable.pakistan));
        flaglist.add(new model("Russia",R.drawable.russia));
        flaglist.add(new model("United States",R.drawable.unitedstates));


        myadapter = new adapter(flaglist,MainActivity.this);
        recyclerView.setAdapter(myadapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem mymitem = menu.findItem(R.id.search);
        searchView = (SearchView) mymitem.getActionView();


        //----for search in toolbar---//
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (!searchView.isIconified())
                {
                    searchView.setIconified(true);

                }
                mymitem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                final List<model> nml = filter(flaglist,newText);
                myadapter.setfilter(nml);
                return true;
            }
        });


        return true;
    }


    //-----operation method for filter----//
    private List<model> filter(List<model> l1, String query)
    {
        query = query.toLowerCase();
        final List<model> newfilteredlist = new ArrayList<>();

        for (model m : l1)
        {
            final String text = m.getName().toLowerCase();
            if (text.startsWith(query))
            {
                newfilteredlist.add(m);
            }
        }

        return newfilteredlist;
    }

}
