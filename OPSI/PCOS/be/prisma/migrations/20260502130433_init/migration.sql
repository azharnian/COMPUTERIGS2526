-- CreateTable
CREATE TABLE "SensorData" (
    "id" TEXT NOT NULL PRIMARY KEY,
    "tankId" TEXT NOT NULL,
    "suhu" REAL,
    "ph" REAL,
    "ch4" REAL,
    "co" REAL,
    "nh3" REAL,
    "co2" REAL,
    "h2s" REAL,
    "airQuality" REAL,
    "deviceTime" DATETIME,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
