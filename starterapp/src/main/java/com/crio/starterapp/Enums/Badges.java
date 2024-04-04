package com.crio.starterapp.Enums;

public enum Badges {
    NINJA,
    CHAMP,
    MASTER;


    public static Badges getBadge_name(int score) {
        if(score >= 1 && score < 30){
            return NINJA;
        }else if(score >= 30 && score < 60){
            return CHAMP;
        }else if(score >= 60 && score <= 100){
            return MASTER;
        }
        return null;
    }
}
