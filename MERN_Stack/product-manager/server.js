const express = require("express");
const cors = require("cors")
const app = express();
    
require("./server/config/mongoose.config");
    
app.use(express.json(),express.urlencoded({ extended: true }), cors());
    
const AllMyProductRoutes = require("./server/routes/product.routes");
AllMyProductRoutes(app);
    
app.listen(8000, () => console.log("The server is all fired up on port 8000"));
