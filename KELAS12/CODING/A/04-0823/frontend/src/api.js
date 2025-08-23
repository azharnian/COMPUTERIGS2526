const BASE = import.meta.env.VITE_BACKEND_URL || "http://localhost:5000";
export async function fetchRooms() {
  const res = await fetch(`${BASE}/api/rooms`);
  return res.json();
}
