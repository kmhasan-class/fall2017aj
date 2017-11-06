package bd.ac.seu.aj.streamlabtask.service;

import bd.ac.seu.aj.streamlabtask.model.Section;
import bd.ac.seu.aj.streamlabtask.repository.SectionRepository;

import java.util.List;

public class SectionService {
    public List<Section> findAll() {
        return SectionRepository.getSectionList();
    }

    public List<Section> findSectionByCourseCode(String courseCode) {
        // ADD CODE HERE
        return null;
    }

    public List<Section> findSectionByFacultyInitials(String facultyInitials) {
        // ADD CODE HERE
        return null;
    }

}
