package jung.project.zlog.entity.board;

import jung.project.zlog.entity.BaseEntity;
import jung.project.zlog.entity.user.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "user")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;

    @ColumnDefault("0")
    private int clickCnt;

    @ManyToOne
    private User user;


}
