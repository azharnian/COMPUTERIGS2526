import express from 'express';
import controller from './sensor.controller.js';
import { createSensorSchema } from './sensor.validation.js';
import validate from '../../middlewares/validate.middleware.js';

const router = express.Router();

router.post('/', validate(createSensorSchema), controller.create);
router.get('/:tankId/latest', controller.getLatest);

export default router;