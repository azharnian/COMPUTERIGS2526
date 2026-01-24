import { type Student } from "../types/Student"

interface StudentItemProps {
    student : Student,
    onDelete : (id : number) => void
}

export default function StudentItem({student, onDelete} : StudentItemProps) {

    return(
        <>
        <li>
            {student.name} - {student.age}
            <button onClick={() => onDelete(student.id)}>Delete</button>
        </li>
        </>
    )
}