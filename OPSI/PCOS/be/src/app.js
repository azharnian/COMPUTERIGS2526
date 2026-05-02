import express from 'express';
import cors from 'cors';
import routes from './routes/index.js';
import dashboardRoutes from './modules/dashboard/dashboard.routes.js';
import path from 'path';
import { fileURLToPath } from 'url';

import errorHandler from './middlewares/error.middleware.js';

const app = express();

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.use('/public', express.static(path.join(__dirname, 'public')));
app.use(cors());
app.use(express.json());

app.get('/', (req, res) => {
    res.redirect('/dashboard');
});

app.use('/dashboard', dashboardRoutes);
app.use('/api', routes);

app.use(errorHandler);

export default app;
