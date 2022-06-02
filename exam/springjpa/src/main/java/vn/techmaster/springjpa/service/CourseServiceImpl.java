package vn.techmaster.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.springjpa.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    public CourseRepository courseRepository;

    // Tính điểm trung bình một môn bất kỳ

    @Override
    public float avgScoreByCourse(String courseName) {
        return courseRepository.calAverageScoreByCourse(courseName);
    }

}
