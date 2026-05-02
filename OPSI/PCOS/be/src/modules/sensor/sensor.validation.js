import Joi from 'joi';

export const createSensorSchema = Joi.object({
    tank_id: Joi.string().required(),

    suhu: Joi.number().optional(),
    ph: Joi.number().optional(),

    ch4: Joi.number().optional(),
    co: Joi.number().optional(),
    nh3: Joi.number().optional(),
    co2: Joi.number().optional(),
    h2s: Joi.number().optional(),

    air_quality: Joi.number().optional(),

    // optional timestamp dari device
    deviceTime: Joi.alternatives().try(
        Joi.string().isoDate(),
        Joi.number()
        ).optional()
        })
        // minimal harus ada 1 data sensor
        .or(
        'suhu',
        'ph',
        'ch4',
        'co',
        'nh3',
        'co2',
        'h2s',
        'air_quality'
);