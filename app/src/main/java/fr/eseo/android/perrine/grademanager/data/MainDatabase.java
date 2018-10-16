package fr.eseo.android.perrine.grademanager.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Comment.class, Grade.class, Jury.class, Project.class, User.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {

    private static MainDatabase INSTANCE;

    public abstract CommentDao commentDao();

    public abstract GradeDao gradeDao();

    public abstract JuryDao juryDao();

    public abstract ProjectDao projectDao();

    public abstract UserDao userDao();

    public static MainDatabase getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, MainDatabase.class, "main.db")
                .fallbackToDestructiveMigration()
                //.addCallback(new MainDatabaseCallback())
                .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}

