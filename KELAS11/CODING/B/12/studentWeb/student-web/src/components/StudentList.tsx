import { type Student } from "../types/Student";
import StudentItem from "./StudentItem";

interface StudentListProps {
    students : Student[]
    onDelete: (id : number) => void
}

export default function StudentList({students, onDelete} : StudentListProps){
    return(
        <>
            <ul>
                {
                    students.map(student => (
                        <StudentItem
                            key={student.id}
                            student={student}
                            onDelete={onDelete}
                        />
                    ))
                }
            </ul>
        </>
    )
}
