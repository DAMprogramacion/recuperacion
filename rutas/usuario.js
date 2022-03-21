const express = require('express')
const { registrar } = require('../controladores/usuario')
const { validarUsuarioRegistro } = require('../middleware/validar_usuario')
const router = express.Router()


//ruta de registro (endpoints)
router.post('/registro', validarUsuarioRegistro, registrar )

//ruta login, solo recibe email y la password

module.exports = router