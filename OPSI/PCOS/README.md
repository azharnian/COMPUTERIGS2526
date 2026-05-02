# PCOS IoT Monitoring

Project ini terdiri dari dua bagian:

- `be`: backend Express + Prisma + SQLite untuk menerima data sensor dan menampilkan dashboard.
- `iot-pcos`: firmware ESP32 berbasis PlatformIO untuk membaca sensor dan mengirim data ke backend.

## Prasyarat

Pastikan sudah tersedia:

- Node.js 20. Project backend memakai `.nvmrc`, jadi disarankan pakai `nvm`.
- npm.
- PlatformIO untuk build/upload firmware ESP32.
- ESP32 Dev Module.

## Menjalankan Backend

Masuk ke folder backend:

```bash
cd OPSI/PCOS/be
```

Aktifkan Node 20:

```bash
nvm use
```

Install dependency:

```bash
npm install
```

Siapkan file env:

```bash
cp .env.example .env
```

Isi `.env` sesuai kebutuhan. Contoh:

```env
APP_NAME=iot-backend
NODE_ENV=development
PORT=8080
DATABASE_URL="file:./dev.db"
DEFAULT_TANK=tank_1
```

Jalankan migrasi database:

```bash
npx prisma migrate dev
```

Jalankan backend:

```bash
npm run start
```

Atau saat development:

```bash
npm run dev
```

Dashboard dapat dibuka di:

```text
http://localhost:8080/dashboard
```

Jika `PORT` di `.env` kamu ubah, sesuaikan URL dashboard dengan port tersebut.

## Endpoint Backend

Menerima data sensor:

```http
POST /api/sensors
```

Contoh body JSON:

```json
{
  "tank_id": "tank_1",
  "suhu": 28.5,
  "ph": 7.1,
  "ch4": 120,
  "co": 20,
  "nh3": 5,
  "co2": 450,
  "h2s": 1.2,
  "air_quality": 80,
  "deviceTime": 1710000000000
}
```

Mengambil data sensor terbaru:

```http
GET /api/sensors/:tankId/latest
```

Data realtime dashboard:

```http
GET /api/dashboard/data
```

Contoh dengan beberapa tank:

```text
http://localhost:8080/api/dashboard/data?tanks=tank_1,tank_2,tank_3
```

## Menjalankan Firmware IoT PCOS

Masuk ke folder firmware:

```bash
cd OPSI/PCOS/iot-pcos
```

Edit konfigurasi device:

```text
src/config/config.h
```

Contoh konfigurasi:

```cpp
#define API_URL "http://192.168.1.10:8080/api/sensors"
#define DEVICE_TOKEN "your_device_token"
#define TANK_ID "tank_1"

#define WIFI_SSID "nama_wifi"
#define WIFI_PASS "password_wifi"
```

Catatan penting:

- Gunakan IP laptop/server yang menjalankan backend, bukan `localhost`, karena `localhost` dari ESP32 berarti ESP32 itu sendiri.
- Pastikan ESP32 dan laptop/server berada di jaringan WiFi yang sama.
- Endpoint firmware harus mengarah ke `/api/sensors`, bukan `/api/tanks/data`.

Build firmware:

```bash
pio run
```

Upload ke ESP32:

```bash
pio run --target upload
```

Buka serial monitor:

```bash
pio device monitor
```

Jika command `pio` tidak ditemukan, gunakan path PlatformIO lokal:

```bash
/Users/anas/.platformio/penv/bin/pio run
/Users/anas/.platformio/penv/bin/pio run --target upload
/Users/anas/.platformio/penv/bin/pio device monitor
```

## Urutan Menjalankan Sistem

1. Jalankan backend terlebih dahulu.
2. Pastikan dashboard bisa dibuka di browser.
3. Pastikan `API_URL` di firmware memakai IP dan port backend yang benar.
4. Build dan upload firmware ke ESP32.
5. Buka serial monitor untuk memastikan WiFi tersambung dan HTTP request berhasil.
6. Buka dashboard untuk melihat data masuk.

## Troubleshooting

Jika dashboard tidak bisa dibuka:

- Pastikan backend sedang berjalan.
- Pastikan membuka URL sesuai port, contoh `http://localhost:8080/dashboard`.
- Cek `.env`, khususnya nilai `PORT`.

Jika `npm install` gagal pada `better-sqlite3`:

- Pastikan memakai Node 20:

```bash
nvm use
node -v
```

Jika ESP32 gagal mengirim data:

- Pastikan `API_URL` memakai IP laptop/server, bukan `localhost`.
- Pastikan backend dan ESP32 berada di jaringan yang sama.
- Pastikan endpoint adalah `/api/sensors`.
- Cek serial monitor untuk melihat HTTP response.
