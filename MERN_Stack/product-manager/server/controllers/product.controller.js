const Product = require('../models/product.model');



//(READ)
//FIND ALL
module.exports.findAllProducts = (req, res) => {
    Product.find()
        .then(allDaProducts => res.json(allDaProducts))
        .catch(err => res.json(err));
}
//(READ)
//FIND ONE
module.exports.findOneSingleProduct = (req, res) => {
    Product.findOne({ _id: req.params.product_id })
        .then(oneSingleProduct => res.json(oneSingleProduct))
        .catch(err => res.status(400).jason({err}));
}
//CREATE
module.exports.createNewProduct = (req, res) => {
    Product.create(req.body)
        .then(newlyCreatedProduct => res.json(newlyCreatedProduct))
        .catch(err => res.json(err));
}
//UPDATE
module.exports.updateExistingProduct = (req, res) => {
    Product.findOneAndUpdate(
        { _id: req.params.product_id },
        req.body,
        { new: true, runValidators: true }
    )
        .then(updatedProduct => res.json(updatedProduct))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}
//DELETE
module.exports.deleteAnExistingProduct = (req, res) => {
    Product.deleteOne({ _id: req.params.product_id })
        .then(result => res.json(result))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}
