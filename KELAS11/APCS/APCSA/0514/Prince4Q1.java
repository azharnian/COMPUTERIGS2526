public class Prince4Q1{

}

class School{
    private ArrayList<Student> studentList;
    private ArrayList<Elective> electiveList;

    // 1.a
    private Elective getElectiveByName (String name){
        for (Elective item : electiveList){
            if (item.getName().equals(name)) return item;
        }
    }

    // 1.b
    public void assignElectivesToStudents(){
        for (int i = 0 ; i < getStudentListSize(); i++){
            for (int j = 0; j < 3; j++){
                Student s = studentList.get(i);
                Elective elective = getElectiveByName(s.getChoice(j));
                if (elective){
                    if(elective.getClassSize() < elective.getClassMaxSize()){
                        s.assignElective(elective);
                        elective.addStudent(s);
                        break;
                    }
                }
            }
        }
    }

    // 1.c
    public ArrayList<Student> studentsWithoutElectives(){
        ArrayList<Student> res = new ArrayList<Student>();

        for (Student s : studentList){
            if (!s.hasElective()) res.add(s);
        }

        return res;
    }

    private int getStudentListSize()
    {
        return studentList.size();
    }

}

class Student{

}

class Elective{

}