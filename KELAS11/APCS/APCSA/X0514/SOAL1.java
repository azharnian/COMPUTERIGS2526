import java.util.ArrayList;
public class SOAL1{

}

class School
{
    private ArrayList<Student> studentList;

    private ArrayList<Elective> electiveList;

    private Elective getElectiveByName(String name)
    {
        for (Elective e : electiveList)
        {
            if (e.getName().equals(name))
            {
                return e;
            }
        }

        return null;
    }

    public void assignElectivesToStudents()
    {
        for (Student s : studentList)
        {
            for (int i = 0; i < 3; i++)
            {
                String choice = s.getChoice(i);

                Elective e =
                    getElectiveByName(choice);

                if (e.getClassSize() <
                    e.getMaxClassSize())
                {
                    s.assignElective(e);

                    e.addStudent(s);

                    break;
                }
            }
        }
    }

    public ArrayList<Student>
        studentsWithoutElectives()
    {
        ArrayList<Student> result =
            new ArrayList<Student>();

        for (Student s : studentList)
        {
            if (!s.hasElective())
            {
                result.add(s);
            }
        }

        return result;
    }
}

class Student
{
    private String[] choices;

    private Elective assignedElective;

    public String getChoice(int index)
    {
        return choices[index];
    }

    public boolean hasElective()
    {
        return assignedElective != null;
    }

    public void assignElective(Elective e)
    {
        assignedElective = e;
    }
}

class Elective
{
    private String name;

    private int maxClassSize;

    private int classSize;

    private ArrayList<Student> studentList =
        new ArrayList<Student>();

    public String getName()
    {
        return name;
    }

    public int getMaxClassSize()
    {
        return maxClassSize;
    }

    public int getClassSize()
    {
        return classSize;
    }

    public void addStudent(Student s)
    {
        studentList.add(s);

        classSize++;
    }
}