package jung.project.zlog.repository.board;

import jung.project.zlog.entity.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

//    @Query("select b from Board b order by b.regDate desc")
//    List<Board> findAllSorted();

    Page<Board> findAll(Pageable pageable);

    Page<Board> findBoardByTitleContaining(Pageable pageable, String keyword);

}
