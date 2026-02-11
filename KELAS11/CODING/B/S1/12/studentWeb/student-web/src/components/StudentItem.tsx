import { type Student } from "../types/Student";

interface StudentItemProps {
    student : Student
    onDelete: (id: number) => void
}

function StudentItem({student, onDelete}: StudentItemProps){

    return (
        <>
            <li>
                <p>{student.name}</p>
                <p>{student.age}</p>

                <button onClick={()=> onDelete(student.id)}>Delete</button>
            </li>
        </>
    )
}

export default StudentItem