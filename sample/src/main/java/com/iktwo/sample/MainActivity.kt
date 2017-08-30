package com.iktwo.sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.iktwo.binder.ListDelegateAdapter
import com.iktwo.sample.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), PersonDelegateHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val list = ArrayList<Person>()
        list.add(Person("Alexa", "Cold"))
        list.add(Person("Mary", "January"))
        list.add(Person("John", "Pink", true))
        list.add(Person("Marco", "September"))
        list.add(Person("Michael", "Scott"))

        val adapter = ListDelegateAdapter(list)

        adapter.registerDelegate(PersonDelegate(this))
        adapter.registerDelegate(VIPersonDelegate(this))

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun onPersonSelected(person: Person) {
        Toast.makeText(this, person.lastName, Toast.LENGTH_LONG).show()
    }
}
