package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.batism.BatismDTO;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.group.Group;
import br.com.technosou.gestor.group.GroupSummaryDTO;
import br.com.technosou.gestor.location.Location;
import br.com.technosou.gestor.location.LocationDTO;
import br.com.technosou.gestor.member.child.Child;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static br.com.technosou.gestor.ultils.DateUtils.formatPtBr;

public class MockAdult {

    public Adult mockEntity() throws ParseException {
        return mockEntity(1L);
    }

    public Adult mockEntity(Long id) throws ParseException {
        var entity = new Adult();
        entity.setId(id);
        entity.setFirstName("Ramon" + id);
        entity.setLastName("Rodrigues" + id);
        entity.setBirthdate(formatPtBr("02/07/1993"));
        entity.setGender(Gender.MALE);
        entity.setEmail(id + "ramon@gmail.com");
        entity.setPhone("123456789" + id);
        entity.setGroup(mockGroup(id));
        entity.setBatism(mockBatism(id));
        entity.setCpf("123456789" + id);
        entity.setLocation(mockLocation(id));
        entity.setCivilStatus(CivilStatus.MARRIED);
        entity.setSpouse(mockSpouse(id + 1));
        entity.setChildren(mockChildList());
        entity.setRole(Role.LEADER);
        return entity;
    }

    public List<Adult> mockEntityList() throws ParseException {
        List<Adult> entities = new ArrayList<>();
        for (Long i = 0L; i < 10; i++) {
           entities.add(mockEntity(i));
        }
        return entities;
    }

    public AdultDTO mockDTO() throws ParseException {
        return mockDTO(1L);
    }

    public AdultDTO mockDTO(Long id) throws ParseException {
        var dto = new AdultDTO();
        dto.setId(id);
        dto.setFirstName("Ramon" + id);
        dto.setLastName("Rodrigues" + id);
        dto.setBirthdate(formatPtBr("02/07/1993"));
        dto.setGender(Gender.MALE);
        dto.setEmail(id + "ramon@gmail.com");
        dto.setPhone("123456789" + id);
        dto.setGroup(mockGroupSummaryDTO(id));
        dto.setBatism(mockBatismDTO(id));
        dto.setCpf("123456789" + id);
        dto.setLocation(mockLocationDTO(id));
        dto.setCivilStatus(CivilStatus.MARRIED);
        dto.setSpouse(mockAdultSummaryDTO(id + 1));
        dto.setChildren(mockChildSummaryDTOList());
        dto.setRole(Role.LEADER);
        return dto;
    }

    public Adult mockSpouse(Long id) {
        var entity = new Adult();
        entity.setId(id);
        return entity;
    }

    public AdultSummaryDTO mockAdultSummaryDTO(Long id) throws ParseException {
        var dto = new AdultSummaryDTO();
        dto.setId(id);
        dto.setFirstName("Samara" + id);
        dto.setLastName("Rodrigues");
        dto.setBirthdate(formatPtBr("18/02/1992"));
        return dto;
    }

    public Child mockChild(Long id) throws ParseException {
        var entity = new Child();
        entity.setId(id);
        entity.setFirstName("Antonio" + id);
        entity.setLastName("Rodrigues" + id);
        entity.setGender(Gender.MALE);
        entity.setBirthdate(formatPtBr("13/07/2020"));
        return entity;
    }

    public List<Child> mockChildList() throws ParseException {
        List<Child> children = new ArrayList<Child>();
        Child child = mockChild(1L);
        children.add(child);
//        for (Long i = id; i < 3; i++) {
//            children.add(mockChild(i));
//        }
        return children;
    }

    public ChildSummaryDTO mockChildSummaryDTO(Long id) {
        var dto = new ChildSummaryDTO();
        dto.setId(id);
        dto.setFirstName("Antonio" + id);
        dto.setLastName("Rodrigues" + id);
        return dto;
    }

    public List<ChildSummaryDTO> mockChildSummaryDTOList() {
        List<ChildSummaryDTO> children = new ArrayList<ChildSummaryDTO>();
        ChildSummaryDTO child = mockChildSummaryDTO(1L);
        children.add(child);
//        for (Long i = 0L; i < 3; i++) {
//            children.add(mockChildSummaryDTO(i));
//        }
        System.out.println("children: " + children.get(0).getId());
        return children;
    }

    public Group mockGroup(Long id) {
        var entity = new Group();
        entity.setId(id);
        return entity;
    }

    public GroupSummaryDTO mockGroupSummaryDTO(Long id) {
        var dto = new GroupSummaryDTO();
        dto.setId(id);
        return dto;
    }

    public Batism mockBatism(Long id) throws ParseException {
        var entity = new Batism();
        entity.setBaptismDate(formatPtBr("01/01/200" + id));
        return entity;
    }

    public BatismDTO mockBatismDTO(Long id) throws ParseException {
        var dto = new BatismDTO();
        dto.setBaptismDate(formatPtBr("01/01/200" + id));
        return dto;
    }

    public Location mockLocation(Long id) throws ParseException {
        var entity = new Location();
        entity.setZipCode("2170020" + id);
        return entity;
    }

    public LocationDTO mockLocationDTO(Long id) throws ParseException {
        var dto = new LocationDTO();
        dto.setZipCode("2170020" + id);
        return dto;
    }
}
