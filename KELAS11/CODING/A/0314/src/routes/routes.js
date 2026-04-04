// import express from 'express';
// import {
//     createNote,
// } from './controller.js';
const express = require('express')
const { createNote } = require('./controller.js') 

const router = express.Router();

router.post('/notes', createNote);

module.exports = router