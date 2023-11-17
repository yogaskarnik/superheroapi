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
        assertThat(superheroCreated.getSuperHeroName()).isEqualTo(superhero.getSuperHeroName());
    }

    @Test
    public void whenFindSuperheroById_thenSuperheroShouldBeFound() {
        Long id = 1L;
        Superhero superhero = new Superhero("Batman");
        Mockito.when(superheroRepository.findById(id)).thenReturn(Optional.of(superhero));

        Optional<Superhero> found = superheroService.findById(id);

        assertThat(found).isPresent();
        assertThat(found.get().getSuperHeroName()).isEqualTo(superhero.getSuperHeroName());
    }

    @Test
    public void whenFindSuperheroById_thenSuperheroShouldNotBeFound() {
        Long id = 2L;
        Mockito.when(superheroRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Superhero> found = superheroService.findById(id);

        assertThat(found).isNotPresent();
    }

}
