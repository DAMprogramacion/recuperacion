const express = require('express')
const {listarCoches, crearCoche} = require('../controladores/coche')
const {validarToken} = require('../middleware/validar_usuario')
const res = require('express/lib/response')

const router = express.Router()

router.get('/', validarToken, listarCoches)
router.post('/', validarToken, crearCoche )
module.exports = router