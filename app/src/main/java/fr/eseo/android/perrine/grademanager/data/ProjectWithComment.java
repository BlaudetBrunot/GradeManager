package fr.eseo.android.perrine.grademanager.data;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ProjectWithComment {

    @Embedded
    public Project project;

    @Relation(parentColumn = "id_project", entity = Comment.class, entityColumn = "id_project")
    public List<Comment> comments;
}
