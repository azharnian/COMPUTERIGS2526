import { useState } from "react"
import { type Student } from "../types/Student"

interface StudentFormProps {
    onAdd : (student : Student) => void
}

export default function StudentForm({onAdd} : StudentFormProps){
    const [name, setName] = useState<string>("")
    const [age, setAge] = useState<number>(0)

    const handleSubmit = (e : React.FormEvent) => {
        e.preventDefault()
        onAdd({
            id : Date.now(),
            name : name,
            age : age
        })

        setName("")
        setAge(0)
    }

    const handleOnChangeName = (e : React.ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value )
    
    }

    const handleOnChangeAge = (e : React.ChangeEvent<HTMLInputElement>) => {
        setAge(Number(e.target.value))
    }


    return (
        <>
        <form onSubmit={handleSubmit}>
            <input type="text"
                    placeholder="Name"
                    value={name}
                    onChange={handleOnChangeName}
            />
            <input type="number"
                    placeholder="Age"
                    value={age}
                    onChange={handleOnChangeAge}
            />
            <button>Add</button>
        </form>
        </>
    )
}