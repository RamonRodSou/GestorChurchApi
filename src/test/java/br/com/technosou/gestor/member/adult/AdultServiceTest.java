package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.member.child.Child;
import br.com.technosou.gestor.member.child.ChildRepository;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class AdultServiceTest {

    MockAdult input;

    @InjectMocks
    AdultService service;

    @Mock
    AdultRepository repository;

    @Mock
    ChildRepository childRepository;

    @BeforeEach
    void setUp() {
        input = new MockAdult();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() throws ParseException {
        List<Adult> entities = input.mockEntityList();
        when(repository.findAll())
                .thenReturn(entities);

        List<AdultDTO> dto = service.findAll();

        assertNotNull(dto);
        assertEquals(10, dto.size());
        assertsTestes(dto.get(1), "1");
        assertsTestes(dto.get(3), "3");
        assertsTestes(dto.get(7), "7");
    }

    @Test
    void findById() throws ParseException {
        Adult entity = input.mockEntity(1L);
        entity.setId(1L);
        when(repository.findById(1L))
                .thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result, "1");
    }

    @Test
    void create() throws ParseException {
        AdultDTO dto = input.mockDTO(1L);

        when(repository.save(any(Adult.class))).thenAnswer(i -> {
            Adult a = i.getArgument(0);
            a.setId(1L);
            return a;
        });

        if (dto.getChildren() != null) {
            for (ChildSummaryDTO c : dto.getChildren()) {
                Child child = input.mockChild(c.getId());
                when(childRepository.findById(c.getId())).thenReturn(Optional.of(child));
            }
        }

        AdultDTO result = service.create(dto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(dto.getFirstName(), result.getFirstName());
        assertEquals(dto.getChildren().size(), result.getChildren().size());
    }

    @Test
    void update() throws ParseException {
        Adult entity = input.mockEntity(1L);
        Adult saved = entity;
        saved.setId(1L);

        AdultDTO dto = input.mockDTO(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(saved);

        var result = service.update(dto);

        assertsTestes(result, "1");
    }

    @Test
    void delete() throws ParseException {
        Adult entity = input.mockEntity(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        Optional.ofNullable(entity.getChildren()).ifPresent(List::clear);

        service.delete(1L);

        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(Adult.class));
        verifyNoMoreInteractions(repository);
    }


    private void assertsTestes(AdultDTO dto, String id) {
        assertNotNull(dto);
        assertNotNull(dto.getId());
        assertEquals("Ramon" + id, dto.getFirstName());
        assertEquals("Rodrigues" + id, dto.getLastName());
        assertEquals(Gender.MALE, dto.getGender());

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("self")
                        && l.getHref().endsWith("/api/adults/v1/" + id)
                        && l.getType().equals("GET")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("findAll")
                        && l.getHref().endsWith("/api/adults/v1")
                        && l.getType().equals("GET")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("created")
                        && l.getHref().endsWith("/api/adults/v1/")
                        && l.getType().equals("POST")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("update")
                        && l.getHref().endsWith("/api/adults/v1/")
                        && l.getType().equals("PUT")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("delete")
                        && l.getHref().endsWith("/api/adults/v1/" + id)
                        && l.getType().equals("DELETE")
                )
        );
    }
}