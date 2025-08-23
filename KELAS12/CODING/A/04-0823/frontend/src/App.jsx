import React, { useEffect, useState, useRef } from 'react'
import { createSocket } from './socket'
import { fetchRooms } from './api'

export default function App() {
  const [rooms, setRooms] = useState([])
  const socketRef = useRef(null)

  useEffect(() => {
    fetchRooms().then(data => setRooms(data.rooms || []))
    const socket = createSocket()
    socketRef.current = socket
    return () => socket.disconnect()
  }, [])

  return (
    <div>
      <h1>Chat Rooms</h1>
      <ul>
        {rooms.map(r => <li key={r.id}>{r.name}</li>)}
      </ul>
    </div>
  )
}
