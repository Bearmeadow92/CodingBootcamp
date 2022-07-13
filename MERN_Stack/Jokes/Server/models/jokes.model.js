const mongoose = require("mongoose");

const JokeSchema = new mongoose.Schema(
  {
    setup: {
      type: String,
      required: [true, "set up is required"],
      minlength: [6, "set up must be at least 6 characters long"]
    },
    punchline: {
      type: String,
      required: [true, "Punchline is required"],
      minlength: [6, "Punchline must be at least 6 characters long"]
    },
  },
  { timestamps: true }
);


const Joke = mongoose.model("Joke", JokeSchema);

module.exports = Joke;