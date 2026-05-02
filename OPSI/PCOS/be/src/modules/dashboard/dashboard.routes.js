import express from 'express';
import controller from './dashboard.controller.js';

const router = express.Router();

router.get('/', controller.index);
router.get('/data', controller.data);

export default router;
