package fr.eseo.android.perrine.grademanager.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

@Entity(tableName = "comments", primaryKeys = {"id_project"},
        foreignKeys = {@ForeignKey(entity = Project.class, parentColumns = "id_project", childColumns = "id_project")})
public class Comment {

    @NonNull
    @ColumnInfo(name = "id_project")
    private int idProject;

    @NonNull
    private String text;

    public Comment(@NonNull int idProject, @NonNull String text){
        this.idProject = idProject;
        this.text = text;
    }

    @NonNull
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
