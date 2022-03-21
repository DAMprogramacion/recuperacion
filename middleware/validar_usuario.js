const {response} = require('express')

const nombreValido = (nombre = '') =>{
    return nombre.length !== 0
} 
const passwordValido = (password = '') =>{
    return password.length  >= 6
}

const emailValido = (email = '') => {
    return String(email)
      .toLowerCase()
      .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      )
  }
  

const validarUsuarioRegistro = (req, res = response, next) => {
    
    const { nombre, password, email } = req.body
    if ( !nombreValido(nombre) || !passwordValido(password) 
                || !emailValido(email)) {
        return res.status(400).json (
            {
                ok: false,
                mensajes: 'mala petición'
            }
        )
    }
    next()
}

module.exports = { validarUsuarioRegistro }