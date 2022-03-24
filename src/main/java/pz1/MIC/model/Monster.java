package pz1.MIC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name ="monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "stats_id", referencedColumnName = "id")
    private Stats stats;

    @ManyToOne
    @JoinColumn(name = "monsters_definiton_id", referencedColumnName = "id")
    private MonsterDefinition monsterDefinition;

    @ManyToOne
    @JoinColumn(name = "quest_id", referencedColumnName = "id")
    private Quest quest;
}
