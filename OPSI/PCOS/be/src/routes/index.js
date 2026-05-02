import express from 'express';
import sensorRoutes from '../modules/sensor/sensor.routes.js';
import dashboardRoutes from '../modules/dashboard/dashboard.routes.js';

const router = express.Router();

router.use('/sensors', sensorRoutes);

router.use('/dashboard', dashboardRoutes);

export default router;