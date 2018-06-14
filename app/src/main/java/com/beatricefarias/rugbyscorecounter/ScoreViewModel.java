package com.beatricefarias.rugbyscorecounter;

import android.arch.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    public ScoreViewModel(){
    }

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }
}
