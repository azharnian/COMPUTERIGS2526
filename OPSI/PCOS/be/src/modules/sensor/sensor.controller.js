import * as sensorService from './sensor.service.js';
import { created, success } from '../../utils/response.js';

async function create(req, res, next) {
    try {
        const result = await sensorService.createSensorData(req.body);
        return created(res, result, 'Sensor data saved');
    } catch (err) {
        next(err);
    }
}

async function getLatest(req, res, next) {
    try {
        const { tankId } = req.params;
        const data = await sensorService.getLatestByTank(tankId);

        return success(res, data, 'Latest sensor data');
    } catch (err) {
        next(err);
    }
}

export default {
    create,
    getLatest
};