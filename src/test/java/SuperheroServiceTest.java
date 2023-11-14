import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SuperheroServiceTest {

    @Mock
    private SuperheroRepository superheroRepository;

    @InjectMocks
    private SuperheroService superheroService;

    @Test
    public void whenFindAll_ThenSuperherosShouldBeAvailable(){
        List<Superhero> expectedSuperheroes = Arrays.asList(
                new Superhero(1l,"Batman", "gadgets"),
                new Superhero(2l,"Superman", "fly"));

        Mockito.when(superheroRepository.findAll()).then(expectedSuperheroes);

        List<Superhero> foundSuperheros = superheroService.findAll();

        assertThat(foundSuperheros).isEqualTo(expectedSuperheroes);

    }
}
