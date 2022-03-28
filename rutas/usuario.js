const express = require('express')
const { registrar, loguear } = require('../controladores/usuario')
const { validarUsuarioRegistro, validarUsuarioLogin } = require('../middleware/validar_usuario')
const router = express.Router()


//ruta de registro (endpoints)
router.post('/registro', validarUsuarioRegistro, registrar )

//ruta login, solo recibe email y la password
router.post('/login', validarUsuarioLogin, loguear )


module.exports = router