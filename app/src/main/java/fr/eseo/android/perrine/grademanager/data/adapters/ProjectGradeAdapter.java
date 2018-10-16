package fr.eseo.android.perrine.grademanager.data.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.android.perrine.grademanager.ProjectActivity;
import fr.eseo.android.perrine.grademanager.R;
import fr.eseo.android.perrine.grademanager.data.GradeWithUser;

public class ProjectGradeAdapter extends RecyclerView.Adapter<ProjectGradeAdapter.GradeViewHolder>{

    private ProjectActivity activity;

    private List<GradeWithUser> grades;

    private int minNote;

    private int maxNote;

    private float avgNote;

    public ProjectGradeAdapter(ProjectActivity activity){
        this.activity = activity;
        setGrades(new ArrayList<GradeWithUser>());
    }

    public void setGrades(List<GradeWithUser> grades){
        this.grades = grades;
        if((grades != null) && (grades.size() > 0)){
            minNote = grades.get(0).grade.getNote();
            maxNote = minNote;
            avgNote = 0;
            int nbNotes = grades.size();
            for(GradeWithUser grade : grades){
                if(grade.grade.getNote() < minNote){
                    minNote = grade.grade.getNote();
                }
                if(grade.grade.getNote() > maxNote){
                    maxNote = grade.grade.getNote();
                }
                avgNote += grade.grade.getNote();

            }
            avgNote = avgNote / (float)nbNotes;
        }
    }

    @NonNull
    @Override
    public ProjectGradeAdapter.GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View gradeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_card_layout, parent, false);
        return new GradeViewHolder(gradeView);

    }

    @Override
    public void onBindViewHolder(@NonNull ProjectGradeAdapter.GradeViewHolder holder, int position) {
        final GradeWithUser grade = grades.get(position);
        //holder.prenom.setText(notation.internautes.get(0).getPrenom());
        //holder.nom.setText(notation.internautes.get(0).getNom());
        holder.note.setText(String.valueOf(grade.grade.getNote()));
        if (grade.grade.getNote() == minNote) {
            holder.note
                    .setTextColor(ResourcesCompat.getColor(activity.getResources(), R.color.min_note, null));
        } else if (grade.grade.getNote() == maxNote) {
            holder.note
                    .setTextColor(ResourcesCompat.getColor(activity.getResources(), R.color.max_note, null));
        } else {
            holder.note.setTextColor(
                    ResourcesCompat.getColor(activity.getResources(), R.color.colorPrimaryDark, null));
        }
        if (grade.grade.getNote() < avgNote) {
            holder.note.setBackgroundColor(
                    ResourcesCompat.getColor(activity.getResources(), R.color.low_note, null));
        }
        if (grade.grade.getNote() > avgNote) {
            holder.note.setBackgroundColor(
                    ResourcesCompat.getColor(activity.getResources(), R.color.high_note, null));
        }

    }

    @Override
    public int getItemCount() {
        return (grades!=null)?grades.size():0;
    }

    class GradeViewHolder extends RecyclerView.ViewHolder {

        //private final TextView prenom;

        //private final TextView nom;

        private final TextView note;

        public GradeViewHolder(View view){
            super(view);
            //prenom = view.findViewById(R.id.tv_notation_prenom);
            //nom = view.findViewById(R.id.tv_notation_nom);
            note = view.findViewById(R.id.tv_grade_note);

        }
    }
}
