fetch('/data/photos.json')
  .then(res => res.json())
  .then(photos => {
    const gallery = document.getElementById('gallery');
    photos.forEach(photo => {
      const card = document.createElement('div');
      card.className = 'card';
      card.innerHTML = `
        <img src="${photo.imageUrl}" alt="${photo.title}">
        <h3>${photo.title}</h3>
        <p>$${photo.price}</p>
        <a href="mailto:orders@signalbloom.example?subject=Print%20Order%20${encodeURIComponent(photo.title)}" class="buy">Buy Print</a>
      `;
      gallery.appendChild(card);
    });
  });
