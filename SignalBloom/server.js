const express = require('express');
const path = require('path');
const app = express();

const PORT = process.env.PORT || 3000;

app.use(express.static(path.join(__dirname, 'public')));

app.get('/data/photos.json', (req, res) => {
  res.sendFile(path.join(__dirname, 'data', 'photos.json'));
});

app.get('/data/posts.json', (req, res) => {
  res.sendFile(path.join(__dirname, 'data', 'posts.json'));
});

app.listen(PORT, () => console.log(`Signal Bloom running on port ${PORT}`));
