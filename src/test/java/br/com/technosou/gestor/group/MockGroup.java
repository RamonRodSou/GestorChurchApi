package br.com.technosou.gestor.group;

import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.enums.WeekDays;
import br.com.technosou.gestor.location.Location;
import br.com.technosou.gestor.member.adult.Adult;
import br.com.technosou.gestor.member.adult.AdultSummaryDTO;
import br.com.technosou.gestor.member.child.Child;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static br.com.technosou.gestor.ultils.DateUtils.formatPtBr;

public class MockGroup {

    public Group mockEntity() throws ParseException {
        return mockEntity(1L);
    }

    public Group mockEntity(Long id) throws ParseException {
        var entity = new Group();
        entity.setId(id);
        entity.setName("Maranata" + id);
        entity.setWeekDay(WeekDays.SUNDAY);
        entity.setLocation(mockLocation(id));
        entity.setLeaders(mockAdultList());
        entity.setMembers(mockAdultList());
        entity.setChildren(mockChildList());
        entity.setActive(true);
        return entity;
    }

    public List<Group> mockEntityList() throws ParseException {
        List<Group> entities = new ArrayList<>();
        for (Long i = 0L; i < 10; i++) {
           entities.add(mockEntity(i));
        }
        return entities;
    }

    public GroupDTO mockDTO() throws ParseException {
        return mockDTO(1L);
    }

    public GroupDTO mockDTO(Long id) throws ParseException {
        var dto = new GroupDTO();
        dto.setId(id);
        dto.setName("Maranata" + id);
        dto.setWeekDay(WeekDays.SUNDAY);
        dto.setLocation(mockLocation(id));
        dto.setLeaders(mockAdultSummaryDTOList());
        dto.setMembers(mockAdultSummaryDTOList());
        dto.setChildren(mockChildSummaryDTOList());
        dto.setActive(true);
        return dto;
    }

    public Adult mockAdult(Long id) throws ParseException {
        var entity = new Adult();
        entity.setId(id);
        entity.setFirstName("Ramon" + id);
        entity.setLastName("Rodrigues" + id);
        entity.setGender(Gender.MALE);
        entity.setBirthdate(formatPtBr("02/07/1993"));
        return entity;
    }

    public List<Adult> mockAdultList() throws ParseException {
        List<Adult> entities = new ArrayList<Adult>();
        Adult entity = mockAdult(1L);
        entities.add(entity);
        for (Long i = 0L; i < 3; i++) {
            entities.add(mockAdult(i));
        }
        return entities;
    }

    public AdultSummaryDTO mockAdultSummaryDTO(Long id) {
        var dto = new AdultSummaryDTO();
        dto.setId(id);
        dto.setFirstName("Ramon" + id);
        dto.setLastName("Rodrigues" + id);
        return dto;
    }

    public List<AdultSummaryDTO> mockAdultSummaryDTOList() {
        List<AdultSummaryDTO> children = new ArrayList<AdultSummaryDTO>();
        AdultSummaryDTO child = mockAdultSummaryDTO(1L);
        children.add(child);
        for (Long i = 0L; i < 3; i++) {
            children.add(mockAdultSummaryDTO(i));
        }
        System.out.println("adult: " + children.get(0).getId());
        return children;
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
        for (Long i = 0L; i < 3; i++) {
            children.add(mockChildSummaryDTO(i));
        }
        System.out.println("children: " + children.get(0).getId());
        return children;
    }

    public Location mockLocation(Long id) throws ParseException {
        var entity = new Location();
        entity.setZipCode("2170020" + id);
        return entity;
    }
}
