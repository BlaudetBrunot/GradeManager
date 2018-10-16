package fr.eseo.android.perrine.grademanager.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.android.perrine.grademanager.MainActivity;
import fr.eseo.android.perrine.grademanager.R;
import fr.eseo.android.perrine.grademanager.data.Project;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private MainActivity activity;

    private  List<Integer> expandedPositions = new ArrayList<>();

    private List<Project> projects;

    public MainAdapter(MainActivity mainActivity){
        this.activity = mainActivity;
        setProjects(new ArrayList<Project>());
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int getItemCount(){
        return projects.size();
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View projectView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_card_layout, parent, false);
        CardView projectCardView = (CardView)projectView;
        projectCardView.setCardElevation(3 * MainActivity.NEW_CARD_COUNTER++);
        return new MainViewHolder(projectView);

    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position){
        final Project project = projects.get(position);
        holder.projectId.setText(project.getIdProject());
        holder.projectTitle.setText(project.getTitle());
        holder.projectDescrProject.setText(project.getDescrProject());
        holder.projectConf.setText(project.getConf());
        holder.projectSubmit.setText(String.valueOf(project.isSubmit()));
        holder.projectForenameSup.setText(project.getForenameSup());
        holder.projectSurnameSup.setText(project.getSurnameSup());
        holder.projectJuryMembers.setText(String.valueOf(project.getJuryMembers()));

        if (expandedPositions.contains(position)) {
            holder.projectDescrProject.setVisibility(View.VISIBLE);
            holder.projectJuryMembers.setVisibility(View.VISIBLE);
        } else {
            holder.projectDescrProject.setVisibility(View.GONE);
            holder.projectJuryMembers.setVisibility(View.GONE);

        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.clickProjectCard(project);
            }
        });
        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView descr = (TextView) v.findViewById(R.id.tv_project_descr);
                TextView descrLabel = (TextView) v.findViewById(R.id.tv_project_descr_label);
                TextView juryMembers = (TextView) v.findViewById(R.id.tv_project_juryMembers);
                TextView juryMembersLabel = (TextView) v.findViewById(R.id.tv_project_juryMembers_label);
                if (expandedPositions.contains(position)) {
                    descr.setVisibility(View.GONE);
                    descrLabel.setVisibility(View.GONE);
                    juryMembers.setVisibility(View.GONE);
                    juryMembersLabel.setVisibility(View.GONE);
                    expandedPositions.remove(new Integer(position));
                } else {
                    descr.setVisibility(View.VISIBLE);
                    descrLabel.setVisibility(View.VISIBLE);
                    juryMembers.setVisibility(View.VISIBLE);
                    juryMembersLabel.setVisibility(View.VISIBLE);
                    expandedPositions.add(position);
                }
                return true;
            }
        });
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        private final View view;

        private final TextView projectId;
        private final TextView projectTitle;
        private final TextView projectDescrProject;
        private final TextView projectConf;
        private final TextView projectSubmit;
        private final TextView projectForenameSup;
        private final TextView projectSurnameSup;
        private final TextView projectJuryMembers;

        public MainViewHolder(View view){
            super(view);
            this.view = view;
            projectId = view.findViewById(R.id.tv_project_id);
            projectTitle = view.findViewById(R.id.tv_project_title);
            projectDescrProject = view.findViewById(R.id.tv_project_descr);
            projectConf = view.findViewById(R.id.tv_project_conf);
            projectSubmit = view.findViewById(R.id.tv_project_submit);
            projectForenameSup = view.findViewById(R.id.tv_project_forenameSup);
            projectSurnameSup = view.findViewById(R.id.tv_project_surnameSup);
            projectJuryMembers = view.findViewById(R.id.tv_project_juryMembers);
        }
    }
}
