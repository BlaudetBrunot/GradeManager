package fr.eseo.android.perrine.grademanager.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;

@Entity(tableName = "projects", primaryKeys = {"id_project"} ,
        foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "forename", childColumns = "forename"),
                        @ForeignKey(entity = User.class, parentColumns = "surname", childColumns = "surname")})
public class Project {

    @PrimaryKey
    @ColumnInfo(name = "id_project")
    private int idProject;

    @NonNull
    private String title;

    @NonNull
    private String descrProject;

    @NonNull
    private int conf;

    @NonNull
    private boolean submit;

    @NonNull
    @ColumnInfo(name = "forename")
    private String forenameSup;

    @NonNull
    @ColumnInfo(name = "surname")
    private String surnameSup;

    @NonNull
    private ArrayList<User> juryMembers;

    private boolean visitorView;

    public Project(@NonNull int idProject, @NonNull String title, @NonNull String descrProject,
                   @NonNull int conf, @NonNull boolean submit, @NonNull String forenameSup,
                   @NonNull String surnameSup, @NonNull ArrayList<User> juryMembers,
                   boolean visitorView){
        this.idProject = idProject;
        this.title = title;
        this.descrProject = descrProject;
        this.conf = conf;
        this.submit =submit;
        this.forenameSup =forenameSup;
        this.surnameSup = surnameSup;
        this.juryMembers = juryMembers;
        this.visitorView = visitorView;
    }

    @NonNull
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    public String getDescrProject() {
        return descrProject;
    }

    public void setDescrProject(String descrProject) {
        this.descrProject = descrProject;
    }

    @NonNull
    public int getConf() {
        return conf;
    }

    public void setConf(int conf) {
        this.conf = conf;
    }

    @NonNull
    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    @NonNull
    public String getForenameSup() {
        return forenameSup;
    }

    public void setForenameSup(String forenameSup) {
        this.forenameSup = forenameSup;
    }

    @NonNull
    public String getSurnameSup() {
        return surnameSup;
    }

    public void setSurnameSup(String surnameSup) {
        this.surnameSup = surnameSup;
    }

    @NonNull
    public ArrayList<User> getJuryMembers() {
        return juryMembers;
    }

    public void setJuryMembers(ArrayList<User> juryMembers) {
        this.juryMembers = juryMembers;
    }

    public boolean isVisitorView() {
        return visitorView;
    }

    public void setVisitorView(boolean visitorView) {
        this.visitorView = visitorView;
    }
}
