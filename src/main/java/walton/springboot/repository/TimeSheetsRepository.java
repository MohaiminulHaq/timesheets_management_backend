package walton.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import walton.springboot.model.TimeSheets;

public interface TimeSheetsRepository extends JpaRepository<TimeSheets, Long>{

}
