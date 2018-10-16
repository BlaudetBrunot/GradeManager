package fr.eseo.android.perrine.grademanager.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    @ColumnInfo(name="username")
    private String username;

    private String forename;

    private String surname;

    @NonNull
    private int idRole;

    private String descr;

    public User(String username, String forename, String surname, int idRole, String descr){
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        this.idRole = idRole;
        this.descr = descr;
    }

    @NonNull
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getForename(){
        return forename;
    }

    public void setForename(String forename){
        this.forename = forename;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    @NonNull
    public int getIdRole(){
        return idRole;
    }

    public void setIdRole(int idRole){
        this.idRole = idRole;
    }

    public String getDescr(){
        return descr;
    }

    public void setDescr(String descr){
        this.descr = descr;
    }
}
