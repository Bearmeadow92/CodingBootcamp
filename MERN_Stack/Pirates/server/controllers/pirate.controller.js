
const Pirate = require('../models/pirate.model');



//(READ)
//FIND ALL
module.exports.findAllPirates = (req, res) => {
    Pirate.find()
        .then(allDaPirates => res.json(allDaPirates))
        .catch(err => res.json(err));
}
//(READ)
//FIND ONE
module.exports.findOneSinglePirate = (req, res) => {
    Pirate.findOne({ _id: req.params.pirate_id })
        .then(oneSinglePirate => res.json(oneSinglePirate))
        .catch(err => res.status(400).jason(err));
}
//CREATE
module.exports.createNewPirate = (req, res) => {
    Pirate.create(req.body)
        .then(newlyCreatedPirate => res.json(newlyCreatedPirate))
        .catch(err => res.status(400).json(err));
}
//UPDATE
// module.exports.updateExistingPirate = (req, res) => {
//     Pirate.findOneAndUpdate(
//         { _id: req.params.pirate_id },
//         req.body,
//         { new: true, runValidators: true }
//     )
//         .then(updatedPirate => res.json(updatedPirate))
//         .catch(err => res.json({ message: 'Something went wrong', error: err }));
// }
//DELETE
module.exports.deleteAnExistingPirate = (req, res) => {
    Pirate.deleteOne({ _id: req.params.pirate_id })
        .then(result => res.json(result))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}
