package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.Activity.InsertNotesActivity;

import android.content.Intent;
import android.os.Bundle;


import com.example.mynotes.Adapter.NotesAdapter;
import com.example.mynotes.ViewModel.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView notesRecycler;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn = findViewById(R.id.newNotesBtn);
        notesRecycler = findViewById(R.id.notesRecycler);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        newNotesBtn.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, InsertNotesActivity.class));
        });

        notesViewModel.getallNotes.observe(this, notes ->{
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            notesRecycler.setLayoutManager(manager);
            adapter = new NotesAdapter(MainActivity.this, notes);
            notesRecycler.setAdapter(adapter);

            //recyclerView = findViewById(R.id.recycler_view);
            //LinearLayoutManager manager = new LinearLayoutManager(this);
            //recyclerView.setLayoutManager(manager);
            //recyclerView.setHasFixedSize(true);
            //adapter = new MyAdapter();
            //recyclerView.setAdapter(adapter);
        });
    }
}