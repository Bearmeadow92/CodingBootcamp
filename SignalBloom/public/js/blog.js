fetch('/data/posts.json')
  .then(res => res.json())
  .then(posts => {
    const container = document.getElementById('posts');
    posts.forEach(post => {
      const article = document.createElement('article');
      article.innerHTML = `
        <h3>${post.title}</h3>
        <small>${post.date}</small>
        <p>${post.content}</p>
      `;
      container.appendChild(article);
    });
  });
