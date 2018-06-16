package com.iktwo.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.iktwo.binder.ListDelegateAdapter;
import com.iktwo.sample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonDelegateHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Alexa", "Cold"));
        list.add(new Person("Mary", "January"));
        list.add(new Person("John", "Pink", true));
        list.add(new Person("Marco", "September"));
        list.add(new Person("Michael", "Scott"));

        ListDelegateAdapter adapter = new ListDelegateAdapter(list);

        adapter.registerDelegate(new PersonDelegate(this));
        adapter.registerDelegate(new VIPersonDelegate());

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPersonSelected(Person person) {
        Toast.makeText(this, person.lastName, Toast.LENGTH_LONG).show();
    }
}
