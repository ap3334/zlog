package jung.project.zlog.dto.board;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardDto {

    private int id;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

}
