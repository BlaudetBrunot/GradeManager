package fr.eseo.android.perrine.grademanager.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public class GradeDao {

    private List<Grade> listGrades = new ArrayList<Grade>();
    private int idProject;
    private String username;
    private int note;
    private Grade grade = new Grade(idProject, username, note);

    @Query("SELECT * FROM grades")
    public List<Grade> findAllGrades(){return listGrades;}

    @Query("SELECT * FROM grades WHERE id_project = :idProject")
    public Grade findGradeForProject(int idProject){return grade;}

    public List<GradeWithUser> listGradeWithUser = new ArrayList<GradeWithUser>();
    private GradeWithUser gradeWithUser = new GradeWithUser();
    public GradeWithUser findGradeWithUserForProject(int idProject){return gradeWithUser;}

}
