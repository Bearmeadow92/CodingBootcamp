const PirateController = require('../controllers/pirate.controller');
module.exports = app => {
    app.get('/api/pirates', PirateController.findAllPirates);
    app.get('/api/pirates/:pirate_id', PirateController.findOneSinglePirate);
//     app.put('/api/pirates/:pirate_id', PirateController.updateExistingPirate);
    app.post('/api/pirates', PirateController.createNewPirate);
    app.delete('/api/pirates/:pirate_id', PirateController.deleteAnExistingPirate);
}
