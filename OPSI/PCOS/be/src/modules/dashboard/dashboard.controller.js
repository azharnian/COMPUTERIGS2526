import { getLatestByTank, getLatestByTanks } from '../sensor/sensor.service.js';
import { success } from '../../utils/response.js';

const DEFAULT_TANKS = ['tank_1', 'tank_2', 'tank_3'];

function getTankIds(input) {
    if (!input) return DEFAULT_TANKS;

    return String(input)
        .split(',')
        .map((tankId) => tankId.trim())
        .filter(Boolean);
}

async function index(req, res, next) {
    try {
        const tankIds = getTankIds(req.query.tanks);
        const activeTankId = req.query.tank || tankIds[0];
        
        const [activeData, tanks] = await Promise.all([
            getLatestByTank(activeTankId),
            getLatestByTanks(tankIds)
        ]);

        res.render('dashboard', {
            tankId: activeTankId,
            data: activeData,
            tankIds,
            tanks
        });

    } catch (err) {
        next(err);
    }
}

async function data(req, res, next) {
    try {
        const tankIds = getTankIds(req.query.tanks);
        const tanks = await getLatestByTanks(tankIds);

        return success(res, { tanks }, 'Dashboard data');
    } catch (err) {
        next(err);
    }
}

export default {
    index,
    data
};
