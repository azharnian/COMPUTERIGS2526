import express from 'express';
import {
  createNote,
  getNotes,
  getNoteById,
  editNoteById,
  deleteNoteById
} from '../controller/note-controller.js';

const notes = express.Router();

notes.post('/notes', createNote);
notes.get('/notes', getNotes);
notes.get('/notes/:id', getNoteById);
notes.put('/notes/:id', editNoteById);
notes.delete('/notes/:id', deleteNoteById);

export default notes;