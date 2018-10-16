package fr.eseo.android.perrine.grademanager.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.android.perrine.grademanager.ProjectActivity;
import fr.eseo.android.perrine.grademanager.R;
import fr.eseo.android.perrine.grademanager.data.Project;
import fr.eseo.android.perrine.grademanager.data.ProjectWithComment;

public class ProjectCommentAdapter extends RecyclerView.Adapter<ProjectCommentAdapter.CommentViewHolder> {

    private ProjectActivity activity;

    private List<ProjectWithComment> comments;

    private Project project;

    public ProjectCommentAdapter(ProjectActivity activity){
        this.activity = activity;
        setComments(new ArrayList<ProjectWithComment>());
    }

    public void setComments(List<ProjectWithComment> comments) {
        this.comments = comments;
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View commentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card_layout, parent, false);
        return new CommentViewHolder(commentView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectCommentAdapter.CommentViewHolder holder, int numeroProjet) {
        ProjectWithComment comment = comments.get(numeroProjet);
        //holder.acteurNom.setText(roleArtiste.artistes.get(0).getPrenom()+" "+roleArtiste.artistes.get(0).getNom());
        //holder.acteurRole.setText(roleArtiste.role.getNomRole());
        holder.comment.setText(comment. comments.get(numeroProjet).getText());
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        //private final TextView acteurNom;
        //private final TextView acteurRole;
        private final TextView comment;

        public CommentViewHolder(View view){
            super(view);
            comment = view.findViewById(R.id.tv_comment_text);
        }
    }




}
