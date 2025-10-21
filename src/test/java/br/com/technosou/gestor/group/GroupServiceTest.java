package br.com.technosou.gestor.group;

import br.com.technosou.gestor.member.adult.AdultRepository;
import br.com.technosou.gestor.member.child.ChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

    MockGroup input;

    @InjectMocks
    GroupService service;

    @Mock
    GroupRepository repository;

    @Mock
    AdultRepository adultRepository;

    @Mock
    ChildRepository childRepository;

    @BeforeEach
    void setUp() {
        input = new MockGroup();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() throws ParseException {
        List<Group> entities = input.mockEntityList();
        when(repository.findAll())
                .thenReturn(entities);

        List<GroupDTO> dto = service.findAll();

        assertNotNull(dto);
        assertEquals(10, dto.size());
        assertsTestes(dto.get(1), "1");
        assertsTestes(dto.get(3), "3");
        assertsTestes(dto.get(7), "7");
    }

    @Test
    void findById() throws ParseException {
        Group entity = input.mockEntity(1L);
        entity.setId(1L);
        when(repository.findById(1L))
                .thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result, "1");
    }

    @Test
    void create() throws ParseException {
        GroupDTO dto = input.mockDTO(1L);

        when(repository.save(any(Group.class))).thenAnswer(i -> {
            Group a = i.getArgument(0);
            a.setId(1L);
            return a;
        });

        GroupDTO result = service.create(dto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(dto.getName(), result.getName());
        assertEquals(dto.getChildren().size(), result.getChildren().size());
    }

    @Test
    void update() throws ParseException {
        Group entity = input.mockEntity(1L);
        Group saved = entity;
        saved.setId(1L);

        GroupDTO dto = input.mockDTO(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(saved);

        var result = service.update(dto);

        assertsTestes(result, "1");
    }

    @Test
    void delete() throws ParseException {
        Group entity = input.mockEntity(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        Optional.ofNullable(entity.getLeaders()).ifPresent(List::clear);
        Optional.ofNullable(entity.getMembers()).ifPresent(List::clear);
        Optional.ofNullable(entity.getChildren()).ifPresent(List::clear);

        service.delete(1L);

        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(Group.class));
    }


    private void assertsTestes(GroupDTO dto, String id) {
        assertNotNull(dto);
        assertNotNull(dto.getId());
        assertEquals("Maranata" + id, dto.getName());

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("self")
                        && l.getHref().endsWith("/api/groups/v1/" + id)
                        && l.getType().equals("GET")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("findAll")
                        && l.getHref().endsWith("/api/groups/v1")
                        && l.getType().equals("GET")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("created")
                        && l.getHref().endsWith("/api/groups/v1/")
                        && l.getType().equals("POST")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("update")
                        && l.getHref().endsWith("/api/groups/v1/")
                        && l.getType().equals("PUT")
                )
        );

        assertNotNull(dto.getLinks().stream()
                .anyMatch(l -> l.getRel().value().equals("delete")
                        && l.getHref().endsWith("/api/groups/v1/" + id)
                        && l.getType().equals("DELETE")
                )
        );
    }
}