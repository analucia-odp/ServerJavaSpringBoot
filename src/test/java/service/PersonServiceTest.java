package service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    PersonService personService;

    @Mock
    PersonDao personDao;

    Person person;

    @BeforeEach
    public void setUp(){
        person = new Person(UUID.randomUUID(),"Ana Teste");
    }

   @Test
    void shouldInsertPersonWithNameAndWithIdWithSuccess(){
       when(personDao.getAllPersons()).thenReturn(Collections.singletonList(person));

       List<Person> persons = personService.getAllPersons();

       assertEquals(Collections.singletonList(person), persons);
       verifyNoMoreInteractions(personDao);
   }
}
