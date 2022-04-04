const {response} = require('express')
const jwt = require('jsonwebtoken')
let mensajes = []
const nombreValido = (nombre = '') =>{
    
    if ( nombre === null || nombre.length === 0) {
        mensajes.push('nombre no válido')
        return false
    }
    return true
} 
const passwordValido = (password = '') =>{
    if (password === null || password.length  < 6) {
        mensajes.push('password no válida')
        return false
    }
    return true
}

const emailValido = ( email = '') => {
    if (! String(email).toLowerCase().match(
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    )) {
        mensajes.push('email no válido')
        return false
    }
    return true
  }
  

const validarUsuarioRegistro = (req, res = response, next) => {
    
    const { nombre, email, password } = req.body
    
    if ( !nombreValido(nombre) | !passwordValido(password) 
                | !emailValido(email)) {
        return res.status(400).json (
            {
                ok: false,
                mensajes
            }
        )
    }
    next()
}

const validarUsuarioLogin = (req, res = response, next) => {
    
    const { email, password } = req.body
  
    if (  !passwordValido(password) | !emailValido(email)) {
        return res.status(400).json (
            {
                ok: false,
                mensajes
            }
        )
    }
    next()
}

const validarToken = (req, res = response, next) => {
    
    const token = req.header('x-token')
    if (!token) {
        return res.status(400).json ({
            ok : false,
            msg : 'no token'
        })
    }
    try {
        const {id, email} =  jwt.verify(token, process.env.SECRET_KEY)
        req.id_usuario = id
        req.email  =email
    } catch (error) {
        console.log(error);
        return res.status(400).json ({
            ok : false,
            msg : 'token no válido'
        })
    }
    
    next()
}

module.exports = { validarUsuarioRegistro, validarUsuarioLogin, validarToken }