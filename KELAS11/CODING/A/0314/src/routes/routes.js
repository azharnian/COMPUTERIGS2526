const express = require('express')
const { createNote, getNotes, getNoteById, editNoteById, deleteNoteById } = require('./controller.js') 

const router = express.Router();

router.post('/notes', createNote);
router.get('/notes', getNotes);
router.get('/notes/:id', getNoteById);
router.put('/notes/:id', editNoteById);
router.delete('/notes/:id', deleteNoteById);

module.exports = router