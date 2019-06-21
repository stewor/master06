package pl.stew.themstew.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CzasRepo extends CrudRepository<Czas , Long> {
}
