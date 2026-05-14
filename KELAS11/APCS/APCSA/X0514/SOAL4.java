public class SOAL4{

}
class Student
{
    private String studentName;

    private int studentID;

    public Student(String name, int id)
    {
        studentName = name;

        studentID = id;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public int getStudentID()
    {
        return studentID;
    }
}

class Classroom
{
    private String teacherName;

    private Student[] students;

    public Classroom(String teacher,
                     Student[] s)
    {
        teacherName = teacher;

        students = s;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public Student[] getStudents()
    {
        return students;
    }
}

class School
{
    private Classroom[] allClassrooms;

    public School(Classroom[] rooms)
    {
        allClassrooms = rooms;
    }

    public String findStudent(String teacher,
                              int id)
    {
        // sequential search classroom
        for (Classroom c : allClassrooms)
        {
            if (c.getTeacherName()
                    .equals(teacher))
            {
                Student[] arr =
                    c.getStudents();

                // binary search student
                int low = 0;

                int high = arr.length - 1;

                while (low <= high)
                {
                    int mid =
                        (low + high) / 2;

                    if (arr[mid]
                            .getStudentID()
                            == id)
                    {
                        return arr[mid]
                            .getStudentName();
                    }

                    else if (arr[mid]
                                .getStudentID()
                                < id)
                    {
                        low = mid + 1;
                    }

                    else
                    {
                        high = mid - 1;
                    }
                }
            }
        }

        return "Student Not Found.";
    }
}