const ProductController = require('../controllers/product.controller');
module.exports = app => {
    app.get('/api/products', ProductController.findAllProducts);
    app.get('/api/products/:product_id', ProductController.findOneSingleProduct);
    app.put('/api/products/:product_id', ProductController.updateExistingProduct);
    app.post('/api/products', ProductController.createNewProduct);
    app.delete('/api/products/:product_id', ProductController.deleteAnExistingProduct);
}
