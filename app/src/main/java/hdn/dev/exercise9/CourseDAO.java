package hdn.dev.exercise9;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@androidx.room.Dao
public interface CourseDAO {
    @Insert
    void insert(Course course);
    @Update
    void update(Course course);
    @Delete
    void delete(Course course);
    @Query("DELETE FROM courses")
    void deleteAllCourses();
    @Query("SELECT * FROM courses ORDER BY name ASC")
    List<Course> getAllCourse();
}
