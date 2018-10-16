package fr.eseo.android.perrine.grademanager.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

@Entity(tableName = "grades", primaryKeys ={"id_project","username"} ,
        foreignKeys = {@ForeignKey(entity=Project.class, parentColumns = "id_project", childColumns = "id_project"),
                @ForeignKey(entity = User.class, parentColumns = "username",childColumns = "username")})
public class Grade {

    @NonNull
    @ColumnInfo(name = "id_project")
    private int idProject;

    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    @NonNull
    private int note;

    public Grade(@NonNull int idProject, @NonNull String username, @NonNull int note){
        this.idProject = idProject;
        this.username = username;
        this.note = note;
    }

    @NonNull
    public int getIdProject() {
        return idProject;
    }

    public void setIdProjectdProject(int idProject) {
        this.idProject = idProject;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NonNull
    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
