package com.iktwo.sample

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.iktwo.binder.BindingViewHolder

import com.iktwo.binder.ListDelegateAdapter
import com.iktwo.sample.databinding.ActivityMainBinding
import com.iktwo.sample.databinding.DelegatePersonBinding
import com.iktwo.sample.databinding.DelegateVipBinding

import java.util.ArrayList

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

        adapter.registerDelegate<BindingViewHolder<DelegatePersonBinding>>(PersonDelegate(this))
        adapter.registerDelegate<BindingViewHolder<DelegateVipBinding>>(VIPersonDelegate())

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun onPersonSelected(person: Person) {
        Toast.makeText(this, person.lastName, Toast.LENGTH_LONG).show()
    }
}
