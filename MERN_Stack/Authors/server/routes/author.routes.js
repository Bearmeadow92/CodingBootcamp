const AuthorController = require('../controllers/author.controller');

module.exports = function(app){
    app.get("/api/authors", AuthorController.list);
    app.post("/api/authors", AuthorController.create);
    app.get("/api/authors/:id", AuthorController.detail);
    app.put("/api/authors/:id", AuthorController.update);
    app.delete("/api/authors/:id", AuthorController.delete);
}