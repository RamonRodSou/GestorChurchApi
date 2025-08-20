package br.com.technosou.gestor.member.adult;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.mapper.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import java.util.List;

import static br.com.technosou.gestor.ultils.DateUtils.formatPtBr;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseObject;
import static br.com.technosou.gestor.mapper.ObjectMapper.parseListObjects;

public class AdultMapperTests {

    MockAdult inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockAdult();
    }

    @Test
    public void parseEntityToDTOTest() throws ParseException {
        AdultDTO output = parseObject(inputObject.mockEntity(), AdultDTO.class);
        entityToDTO(output, 1L);
    }

    @Test
    public void parseEntityListToDTOTest() throws ParseException {
       List<AdultDTO> outputList = parseListObjects(inputObject.mockEntityList(), AdultDTO.class);

        for (long i = 0; i < 10; i++) {
            entityToDTO(outputList.get((int) i), Long.parseLong(String.valueOf(i)));
        }
    }

    @Test
    public void parseDTOToEntityTest() throws ParseException {
        Adult output = ObjectMapper.parseObject(inputObject.mockDTO(), Adult.class);
        DTOToEntity(output, 1L);
    }
    
    private void entityToDTO(AdultDTO output, Long id) {
        assertEquals(id, output.getId());
        assertEquals("Ramon" + id, output.getFirstName());
        assertEquals("Rodrigues" + id, output.getLastName());
        assertEquals("02/07/1993", formatPtBr(output.getBirthdate()));
        assertEquals(Gender.MALE, output.getGender());
        assertEquals(id + "ramon@gmail.com", output.getEmail());
        assertEquals("123456789" + id, output.getPhone());
        assertEquals(id, output.getGroup().getId());
        assertEquals("01/01/200" + id, formatPtBr(output.getBatism().getBaptismDate()));
        assertEquals("123456789" + id, output.getCpf());
        assertEquals("2170020" + id, output.getLocation().getZipCode());
        assertEquals(CivilStatus.MARRIED, output.getCivilStatus());
        assertEquals(1L, output.getChildren().get(0).getId());
        assertEquals( "Antonio" + 1L, output.getChildren().get(0).getFirstName());
        assertEquals(Role.LEADER, output.getRole());
    }

    private void DTOToEntity(Adult output, Long id) {
        assertEquals(id, output.getId());
        assertEquals("Ramon" + id, output.getFirstName());
        assertEquals("Rodrigues" + id, output.getLastName());
        assertEquals("02/07/1993", formatPtBr(output.getBirthdate()));
        assertEquals(Gender.MALE, output.getGender());
        assertEquals(id + "ramon@gmail.com", output.getEmail());
        assertEquals("123456789" + id, output.getPhone());
        assertEquals(id, output.getGroup().getId());
        assertEquals("01/01/200" + id, formatPtBr(output.getBatism().getBaptismDate()));
        assertEquals("123456789" + id, output.getCpf());
        assertEquals("2170020" + id, output.getLocation().getZipCode());
        assertEquals(CivilStatus.MARRIED, output.getCivilStatus());
        assertEquals(1L, output.getChildren().get(0).getId());
        assertEquals( "Antonio" + 1L, output.getChildren().get(0).getFirstName());
        assertEquals( "Rodrigues" + 1L, output.getChildren().get(0).getLastName());
        assertEquals(Role.LEADER, output.getRole());
    }
}
