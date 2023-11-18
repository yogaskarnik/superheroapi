import com.wtm.superheroapi.model.Superhero;
import com.wtm.superheroapi.repository.SuperheroRepository;
import com.wtm.superheroapi.service.SuperheroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SuperheroServiceTest {

    @Mock
    private SuperheroRepository superheroRepository;

    @InjectMocks
    private SuperheroService superheroService;


    @Test
    public void whenFindAll_ThenSuperherosShouldBeAvailable() {
        List<Superhero> expectedSuperheroes = Arrays.asList(
                new Superhero("Batman"),
                new Superhero("Superman"));

        Mockito.when(superheroRepository.findAll()).thenReturn(expectedSuperheroes);

        List<Superhero> foundSuperheros = superheroService.findAll();

        assertThat(foundSuperheros).isEqualTo(expectedSuperheroes);

    }

    @Test
    public void whenCreateSuperhero_thenSuperheroShouldBeCreated() {
        Superhero superhero = new Superhero("Batman");
        Mockito.when(superheroRepository.save(superhero)).thenReturn(superhero);

        Superhero superheroCreated = superheroService.createSuperhero(superhero);

        assertThat(superheroCreated).isNotNull();
        assertThat(superheroCreated.getSuperHeroname()).isEqualTo(superhero.getSuperHeroname());
    }

    @Test
    public void whenFindSuperheroById_thenSuperheroShouldBeFound() {
        Long id = 1L;
        Superhero superhero = new Superhero("Batman");
        Mockito.when(superheroRepository.findById(id)).thenReturn(Optional.of(superhero));

        Optional<Superhero> found = superheroService.findById(id);

        assertThat(found).isPresent();
        assertThat(found.get().getSuperHeroname()).isEqualTo(superhero.getSuperHeroname());
    }

    @Test
    public void whenFindSuperheroById_thenSuperheroShouldNotBeFound() {
        Long id = 2L;
        Mockito.when(superheroRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Superhero> found = superheroService.findById(id);

        assertThat(found).isNotPresent();
    }

    @Test
    public void whenUpdateSuperhero_thenSuperheroShouldBeUpdated() {
        Long id = 1L;
        Superhero existingSuperhero = new Superhero("Batman");
        existingSuperhero.setId(id);
        Superhero updatedSuperhero = new Superhero("Batman Returns");

        Mockito.when(superheroRepository.findById(id)).thenReturn(Optional.of(existingSuperhero));
        Mockito.when(superheroRepository.save(existingSuperhero)).thenReturn(updatedSuperhero);

        Optional<Superhero> updated = superheroService.updateSuperhero(id, updatedSuperhero);

        assertThat(updated).isPresent();
        assertThat(updated.get().getSuperHeroname()).isEqualTo(updatedSuperhero.getSuperHeroname());
    }

    @Test
    public void whenDeleteSuperhero_thenSuperheroShouldBeDeleted() {
        Long id = 1L;
        Mockito.doNothing().when(superheroRepository).deleteById(id);
        superheroService.deleteSuperhero(id);
        Mockito.verify(superheroRepository, Mockito.times(1)).deleteById(id);
    }

}
