import { nanoid } from 'nanoid';
import prisma from '../../database/client.js';

function normalizeDeviceTime(input) {
    if (!input) return null;

    if (typeof input === 'number') {
        const d = new Date(input);
        return isNaN(d.getTime()) ? null : d;
    }

    const d = new Date(input);
    return isNaN(d.getTime()) ? null : d;
}

export async function createSensorData(payload) {
    const data = {
        id: nanoid(),
        tankId: payload.tank_id,


        suhu: payload.suhu ?? null,
        ph: payload.ph ?? null,

        ch4: payload.ch4 ?? null,
        co: payload.co ?? null,
        nh3: payload.nh3 ?? null,
        co2: payload.co2 ?? null,
        h2s: payload.h2s ?? null,

        airQuality: payload.air_quality ?? null,

        deviceTime: normalizeDeviceTime(payload.deviceTime)

    };

    return prisma.sensorData.create({ data });
}

export async function getLatestByTank(tankId) {
    return prisma.sensorData.findFirst({
        where: { tankId },
        orderBy: { createdAt: 'desc' }
    });
}

export async function getLatestByTanks(tankIds) {
    const latestRows = await Promise.all(
        tankIds.map((tankId) => getLatestByTank(tankId))
    );

    return tankIds.map((tankId, index) => ({
        tankId,
        data: latestRows[index]
    }));
}
