package com.example.notetable;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;

    }

    private static RoomDatabase.Callback roomCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

//            new PopulateDbAsyncTask(instance).execute();
        }
    };
/*
        THIS WAS AN METHOD TO ADD STATIC DATA IN DATABASE FOR TESTING
 */

//    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private NoteDao noteDao;
//
//        private PopulateDbAsyncTask(NoteDatabase database) {
//
//            noteDao = database.noteDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            noteDao.Insert(new Note("Titre 1", "Description 1"));
//            noteDao.Insert(new Note("Titre 2", "Description 2"));
//            noteDao.Insert(new Note("Titre 3", "Description 3"));
//            noteDao.Insert(new Note("Titre 4", "Description 4"));
//            noteDao.Insert(new Note("Titre 5", "Description 5"));
//            noteDao.Insert(new Note("Titre 6", "Description 6"));
//            noteDao.Insert(new Note("Titre 7", "Description 7"));
//            noteDao.Insert(new Note("Titre 8", "Description 8"));
//            noteDao.Insert(new Note("Titre 9", "Description 9"));
//            noteDao.Insert(new Note("Titre 10", "Description 10"));
//
//
//            return null;
//        }
//    }
}
