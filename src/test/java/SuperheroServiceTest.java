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
                new Superhero(1l,"Batman"),
                new Superhero(2l,"Superman"));

        Mockito.when(superheroRepository.findAll()).thenReturn(expectedSuperheroes);

        List<Superhero> foundSuperheros = superheroService.findAll();

        assertThat(foundSuperheros).isEqualTo(expectedSuperheroes);

    }
}
