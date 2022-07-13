const mongoose = require("mongoose");

const ProductSchema = new mongoose.Schema(
  {
    title: {
      type: String,
      required: [true, "Title is required"],
      minlength: [3, "Title must be at least 3 characters long"]
    },
    price: {
      type: Number,
      required: [true, "Price is required"],
      maxlength: [1, "Price must be at least 1 characters long"]
    },
    description: {
        type: String,
        required: [true, "Description is required"],
        minlength: [3, "Description must be at leat 3 characters long"]
    }
  },
  { timestamps: true }
);


const Product = mongoose.model("Product", ProductSchema);

module.exports = Product;