import express from 'express';
import {
  createNote,
  getAllNotes,
  getNoteById,
  editNoteById,
  deleteNoteById
} from '../controller/note-controller.js';

import {validate, validateQuery} from '../../../middlewares/validate.js';
import {notePayloadSchema, noteQuerySchema} from '../validator/schema.js';

const notes = express.Router();

notes.post('/notes', validate(notePayloadSchema), createNote);
notes.get('/notes', validateQuery(noteQuerySchema), getAllNotes);
notes.get('/notes/:id', getNoteById);
notes.put('/notes/:id', validate(notePayloadSchema), editNoteById);
notes.delete('/notes/:id', deleteNoteById);

export default notes;