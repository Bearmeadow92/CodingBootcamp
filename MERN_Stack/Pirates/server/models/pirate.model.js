const mongoose = require('mongoose');

const PirateSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [
            true,
            "Name is Required !"
            ],
        minlength: [3, "name must be at least 3 characters long!"]
        },
    image_url: {
        type: String,
        required: [true, "Image is Required!"]
    },
    treasureChests: {
        type: Number,
        required: [true, "Number of treasure chests is Required!"],
        minvalue: [1, "number must be greater than 0!"]
    },
    catchPhrase: {
        type: String,
        required: [true, "Catch phrase is required!"]
    },
    crewPosition: {
        type: String,
        required: [true, "Crew position is required!"]
    },
    pegLeg:{
        type: Boolean,
        default: true,
    },
    eyePatch: {
        type: Boolean,
        default: true
    },
    hookHand: {
        type: Boolean,
        default: true
    }
    }, {timestamps: true});

const Pirate = mongoose.model("Pirate", PirateSchema);
module.exports = Pirate;