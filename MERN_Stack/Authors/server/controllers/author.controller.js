const { Author } = require('../models/author.model')


module.exports.list = (request, response) => {
    Author.find({})
          .then(authors => {
              response.json(authors);
          })
          .catch(err => {
              response.status(400).json(err);
          })
}


module.exports.create = (request, response) => {
  const { name } = request.body;
  Author.create({
    name
  })
  .then(Author => {
    response.json(author)
  })
  .catch(err=>{
    response.status(400).json(err)
  })
}

module.exports.detail = (request, response) => {
  const { id } = request.params;
  Author.findOne({_id: id})
    .then(author => {
      response.json(author)
    })
    .catch(err => {
      response.status(400).json(err);
    })
  }

module.exports.update = (request, response) => {
  const { id } = request.params;
  const { name } = request.body;
  Author.findOneAndUpdate({ _id: id }, {
    name
  }, 
    {
      new:true,
      useFindAndModity: true
    }
  )
      .then(author => {
        response.status(400).json(author)
      })
      .catch(err => {
        response.status(400).json(err);
      })
}


module.exports.delete = (request, response) => {
  const { id } = request.params;
  Author.deleteOne({_id : id })
        .then(deleteConfirmation=> {
          response.json(deleteConfirmation);
        })
        .catch(err => {
          response.status(400).json(err);
        })
}