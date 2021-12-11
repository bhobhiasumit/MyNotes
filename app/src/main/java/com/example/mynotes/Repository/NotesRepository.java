package com.example.mynotes.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import com.example.mynotes.Dao.NotesDao;
import com.example.mynotes.Database.NotesDatabase;
import com.example.mynotes.Model.Notes;


import java.util.List;
public class NotesRepository {

    public NotesDao notesDao;
    public LiveData<List<Notes>> getallNotes;

    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getallNotes = notesDao.getallNotes();
    }

    public void insertNotes(Notes notes) {
        notesDao.insertNotes(notes);
    }

    public void deleteNotes(int id) {
        notesDao.deleteNotes(id);
    }

    public void updateNotes(Notes notes) {
        notesDao.updateNotes(notes);
    }
}
