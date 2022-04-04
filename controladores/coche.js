const { response } = require('express')
const Coche = require ('../modelos/Coche')

const listarCoches =  (req, res) => {
    const {id_usuario, email} = req
    res.json({
        ok : true,
        id_usuario,
        email,
        msg: 'listando coches'})
}

const crearCoche = async (req, res) => {

    const {id_usuario} = req
    console.log('usuario', id_usuario)
    const {marca, modelo, matricula} = req.body
   
    try {
        let newCoche = await Coche.findOne( {matricula} )
  
        if (newCoche) {
        return  res.status(400).json({
            ok: false,
            msg: 'matricula ya existe'
            
            })
        }
        newCoche = new Coche({marca, modelo, matricula, id_usuario})
        await newCoche.save()
        return res.status(201).json( {
            ok: true,
            marca,
            modelo,
            matricula
         }
        )

    } catch (error) {
        console.log(error)
        return res.status(400).json({
            ok : false,
            msg: 'mala petición'
        })
    }
    
}

module.exports = {
    listarCoches, crearCoche
}