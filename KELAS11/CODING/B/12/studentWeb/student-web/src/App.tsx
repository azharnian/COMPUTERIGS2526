import { useState } from "react"
import {type Student } from "./types/Student"

import StudentForm from "./components/StudentForm"
import StudentList from "./components/StudentList"

function App(){
  const [students, setStudents] = useState<Student[]>([])

  const addStudent = (student : Student) => {
    setStudents(prev => [...prev, student])
  }

  const deleteStudent = (id : number) => {
    setStudents(prev => prev.filter( s => s.id != id))
  }

  return (
    <>
      <h1>Student List</h1>
      <StudentForm onAdd={addStudent} />
      <StudentList students={students} onDelete={deleteStudent}/>
    </>
  )
}

export default App