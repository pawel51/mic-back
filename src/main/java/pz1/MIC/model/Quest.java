package pz1.MIC.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name ="quests")
public class Quest {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "id")

    private Long id;

    private String name;

    private Long exp;

    private Long prize;

    private Long duration;

    private String description;

    private float questRarity;

    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @OneToMany(mappedBy = "quest")
    private List<Monster> monsters;
}
