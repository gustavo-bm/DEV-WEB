// Define um nome e versão para o cache
const CACHE_NAME = 'cine-sugestao-v1';

// Lista de arquivos essenciais para o App Shell funcionar offline
const urlsToCache = [
  './', // A raiz da aplicação
  './index.jsp',
  './favicon.png',
  'https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap' // Cache da fonte
];

// Evento de Instalação: Salva os arquivos essenciais no cache
self.addEventListener('install', (event) => {
  event.waitUntil(
    caches.open(CACHE_NAME)
      .then((cache) => {
        console.log('Cache aberto:', CACHE_NAME);
        return cache.addAll(urlsToCache);
      })
  );
});

// Evento de Fetch: Intercepta as requisições
self.addEventListener('fetch', (event) => {
  event.respondWith(
    // Tenta encontrar a resposta no cache primeiro
    caches.match(event.request)
      .then((response) => {
        // Se encontrar no cache, retorna a resposta do cache
        if (response) {
          return response;
        }
        // Se não encontrar, faz a requisição à rede
        return fetch(event.request);
      })
  );
});