package br.com.technosou.gestor.member.adult;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.mapper.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static br.com.technosou.gestor.ultils.DateUtils.formatPtBr;

public class AdultMapperTests {

    MockAdult inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockAdult();
    }

    @Test
    public void parseEntityToDTOTest() throws ParseException {
        AdultDTO output = ObjectMapper.parseObject(inputObject.mockEntity(), AdultDTO.class);
        entityToDTO(output, 0L);
    }

    @Test
    public void parseDTOToEntityTest() throws ParseException {
        Adult output = ObjectMapper.parseObject(inputObject.mockDTO(), Adult.class);
        DTOToEntity(output, 0L);
    }
    
    private void entityToDTO(AdultDTO output, Long id) {
        Long mockId = id + 1L;
        assertEquals(id, output.getId());
        assertEquals("Ramon0", output.getFirstName());
        assertEquals("Rodrigues0", output.getLastName());
        assertEquals("02/07/1993", formatPtBr(output.getBirthdate()));
        assertEquals(Gender.MALE, output.getGender());
        assertEquals(id + "ramon@gmail.com", output.getEmail());
        assertEquals("123456789" + id, output.getPhone());
        assertEquals(id, output.getGroup().getId());
        assertEquals("01/01/200" + id, formatPtBr(output.getBatism().getBaptismDate()));
        assertEquals("123456789" + id, output.getCpf());
        assertEquals("2170020" + id, output.getLocation().getZipCode());
        assertEquals(CivilStatus.MARRIED, output.getCivilStatus());
        assertEquals(id, output.getChildren().get(0).getId());
        assertEquals( "Antonio" + id, output.getChildren().get(0).getFirstName());
        assertEquals(mockId, output.getChildren().get(Math.toIntExact(mockId)).getId());
        assertEquals( "Antonio" + mockId, output.getChildren().get(Math.toIntExact(mockId)).getFirstName());
        assertEquals(Role.LEADER, output.getRole());
    }

    private void DTOToEntity(Adult output, Long id) {
        Long mockId = id + 1L;
        assertEquals(id, output.getId());
        assertEquals("Ramon0", output.getFirstName());
        assertEquals("Rodrigues0", output.getLastName());
        assertEquals("02/07/1993", formatPtBr(output.getBirthdate()));
        assertEquals(Gender.MALE, output.getGender());
        assertEquals(id + "ramon@gmail.com", output.getEmail());
        assertEquals("123456789" + id, output.getPhone());
        assertEquals(id, output.getGroup().getId());
        assertEquals("01/01/200" + id, formatPtBr(output.getBatism().getBaptismDate()));
        assertEquals("123456789" + id, output.getCpf());
        assertEquals("2170020" + id, output.getLocation().getZipCode());
        assertEquals(CivilStatus.MARRIED, output.getCivilStatus());
        assertEquals(id, output.getChildren().get(0).getId());
        assertEquals( "Antonio" + id, output.getChildren().get(0).getFirstName());
        assertEquals(mockId, output.getChildren().get(Math.toIntExact(mockId)).getId());
        assertEquals( "Antonio" + mockId, output.getChildren().get(Math.toIntExact(mockId)).getFirstName());
        assertEquals(Role.LEADER, output.getRole());
    }
}
