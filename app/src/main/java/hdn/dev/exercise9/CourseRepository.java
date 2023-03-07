package hdn.dev.exercise9;

import android.app.Application;

import java.util.List;

public class CourseRepository{
    public static CourseDAO dao;

    public CourseRepository(Application application) {
        CourseDatabase database = CourseDatabase.getInstance(application);
        dao = database.Dao();
    }

    public void insert(Course course) {
        dao.insert(course);
    }
    public void update(Course course) {
        dao.update(course);
    }
    public void delete(Course course) {
        dao.delete(course);
    }
    public void deleteAllCourses() {
        dao.deleteAllCourses();
    }
    public List<Course> getAllCourse() {
        return dao.getAllCourse();
    }
}
