import { useState } from "react"
import { type Student } from "./types/Student"

import StudentList from "./components/StudentList"
import StudentForm from "./components/StudentForm"

function App(){
  const [students, setStudents] = useState<Student[]>([])

  const addStudent = (student : Student) => {
    setStudents(prev => [...prev, student])
  }

  const deleteStudent = (id : number) => {
    setStudents(prev => prev.filter(s => s.id !== id))
  }

  return (
    <>
      <div>
        <h1>Student List</h1>
        <StudentForm onAdd={addStudent} />
        <StudentList students={students} onDelete={deleteStudent}/>
      </div>
    </>
  )
}

export default App