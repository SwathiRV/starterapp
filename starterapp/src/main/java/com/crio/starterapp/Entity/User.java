package com.crio.starterapp.Entity;

import com.crio.starterapp.Enums.Badges;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private String id;

    private String name;

    private int score;

    private List<Badges> badgesList;

    public void setScore(int score) {

        this.score = score;
        Badges badge = Badges.getBadge_name(score);
        if(!badgesList.contains(badge)){
            badgesList.add(badge);
        }
    }
}
