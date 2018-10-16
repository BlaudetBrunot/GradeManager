package fr.eseo.android.perrine.grademanager.data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public class CommentDao {

    private List<Comment> listComments = new ArrayList<Comment>();
    private int idProject;
    private String text;
    private Comment comment = new Comment(idProject, text);

    @Query("SELECT * FROM comments")
    public List<Comment> findAllComments(){
        return listComments;
    }

    @Query("SELECT * FROM comments WHERE id_project = :idProject")
    public List<Comment> findAllCommentForProject(int idProject){
        return listComments;
    }

}
