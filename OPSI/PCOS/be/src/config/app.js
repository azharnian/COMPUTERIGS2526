import dotenv from 'dotenv';

dotenv.config();

const config = {
    app: {
        name: process.env.APP_NAME || 'iot-backend',
        env: process.env.NODE_ENV || 'development',
        port: process.env.PORT || 8080
    },

    database: {
        url: process.env.DATABASE_URL || 'file:./dev.db'
    },

    iot: {
        defaultTank: process.env.DEFAULT_TANK || 'tank_1'
    }
};

export default config;