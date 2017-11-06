package bd.ac.seu.aj.streamlabtask.service;

import bd.ac.seu.aj.streamlabtask.model.Faculty;
import bd.ac.seu.aj.streamlabtask.model.Rank;
import bd.ac.seu.aj.streamlabtask.repository.FacultyRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyService {
    public List<Faculty> findAll()  {
        return FacultyRepository.getFacultyList();
    }

    public List<Faculty> findByRank(Rank rank) {
        return findAll()
                .stream()
                .filter(faculty -> faculty.getRank() == rank)
                .collect(Collectors.toList());
    }
}
