package com.beatricefarias.rugbyscorecounter;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView teamAScoreView;
    private TextView teamBScoreView;
    ScoreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        teamAScoreView = findViewById(R.id.teamAScore);
        teamBScoreView = findViewById(R.id.teamBScore);

        teamAScoreView.setText(String.valueOf(viewModel.getScoreTeamA()));
        teamBScoreView.setText(String.valueOf(viewModel.getScoreTeamB()));

        final ArrayList<Points> points = new ArrayList<>();
        points.add(new Points(R.id.tryTeamA, 4, "teamA"));
        points.add(new Points(R.id.tryTeamB, 4, "teamB"));
        points.add(new Points(R.id.goalKickTeamA, 2, "teamA"));
        points.add(new Points(R.id.goalKickTeamB, 2, "teamB"));
        points.add(new Points(R.id.penaltyTeamA, 2, "teamA"));
        points.add(new Points(R.id.penaltyTeamB, 2, "teamB"));
        points.add(new Points(R.id.dropGoalTeamA, 1, "teamA"));
        points.add(new Points(R.id.dropGoalTeamB, 1, "teamB"));

        setListeners(points);
        resetScore();
    }

    /**
     * Method which sets listeners on appropriate buttons counting and updating scores of appropriate team
     *
     * @param points array list containing buttonID, point count and team name information
     */

    private void setListeners(final ArrayList<Points> points) {
        for (int i = 0; i < points.size(); i++) {
            final Points currentElement = points.get(i);

            int buttonId = currentElement.getButtonId();
            Button currentButton = (Button) findViewById(buttonId);

            String teamName = currentElement.getTeam();

            if (teamName == "teamA") {
                currentButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        scoreTeamA = currentElement.getPoints() + viewModel.getScoreTeamA();
                        viewModel.setScoreTeamA(currentElement.getPoints() + viewModel.getScoreTeamA());
                        teamAScoreView.setText(String.valueOf(viewModel.getScoreTeamA()));
                    }
                });
            } else if (teamName == "teamB") {
                currentButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewModel.setScoreTeamB(currentElement.getPoints() + viewModel.getScoreTeamB());
                        teamBScoreView.setText(String.valueOf(viewModel.getScoreTeamB()));
                    }
                });
            }
        }
    }

    /**
     * Method to reset scores of each team
     */
    private void resetScore() {
        Button resetButton = (Button) findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setScoreTeamA(0);
                teamAScoreView.setText(String.valueOf(viewModel.getScoreTeamA()));
                viewModel.setScoreTeamB(0);
                teamBScoreView.setText(String.valueOf(viewModel.getScoreTeamB()));
            }
        });
    }
}