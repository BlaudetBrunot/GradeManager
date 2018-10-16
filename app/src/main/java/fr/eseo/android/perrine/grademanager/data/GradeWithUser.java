package fr.eseo.android.perrine.grademanager.data;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class GradeWithUser {

    @Embedded
    public Grade grade;

    @Relation(parentColumn = "username", entityColumn = "username", entity = User.class)
    public List<User> juryMembers;
}
