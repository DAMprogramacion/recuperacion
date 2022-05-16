const express = require('express')
const {listarCoches, crearCoche, listarCoche, borrarCoche} = require('../controladores/coche')
const {validarToken} = require('../middleware/validar_usuario')
const res = require('express/lib/response')

const router = express.Router()

router.get('/',  listarCoches)
router.get('/:matricula', validarToken, listarCoche)
router.post('/', validarToken, crearCoche )
router.delete('/:matricula', validarToken, borrarCoche )

module.exports = router