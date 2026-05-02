import app from './app.js';
import config from './config/app.js';

app.listen(config.app.port, () => {
    console.log(`🚀 ${config.app.name} running on http://localhost:${config.app.port}`);
});
