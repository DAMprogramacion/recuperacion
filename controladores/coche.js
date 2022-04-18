const { response } = require('express')
const Coche = require ('../modelos/Coche')

const listarCoches = async (req, res) => {
   // const {id_usuario, email} = req
    const coches = await Coche.find()
    res.json({
        ok : true,
        msg: 'listando coches',
        coches
    })
}
const listarCoche = async (req, res) => {
     const {id_usuario} = req
     const matricula = req.params.matricula

     const coche = await Coche.findOne({matricula})
    
     if (!coche ) {
        return res.status(401).json({
            ok : false,
            msg: 'no existe esa matrícula',
            
        })
     }
     //si coche suu id_usuario es el mismo que id_usario del token
     //puedo listar el coche, si no digo que no está autorizado
     if (coche.id_usuario != id_usuario) {
         return res.status(401).json({
            ok : false,
            msg: 'no autorizado',
            
        })
     }
     res.json({
         ok : true,
         msg: 'listando coche',
         coche
     })
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
const borrarCoche = async (req, res) => {
    const {id_usuario} = req
    const matricula = req.params.matricula
 

    let coche = await Coche.findOne({matricula})
   
    if (!coche ) {
       return res.status(401).json({
           ok : false,
           msg: 'no existe esa matrícula',
           
       })
    }
    //si coche suu id_usuario es el mismo que id_usario del token
    //puedo listar el coche, si no digo que no está autorizado
    if (coche.id_usuario != id_usuario) {
        return res.status(401).json({
           ok : false,
           msg: 'no autorizado',
           
       })
    }
    coche = await Coche.deleteOne({matricula})
    res.json({
        ok : true,
        msg: 'borrado coche:',
        coche
    })
}

module.exports = {
    listarCoches, crearCoche, listarCoche, borrarCoche
}