let selectedCategory = '';

async function loadStores(category) {
    if (!category) {
        document.getElementById('searchSection').style.display = 'none';
        document.getElementById('productsList').innerHTML = '';
        return;
    }

    selectedCategory = category;
    try {
        const response = await fetch(`/api/stores?category=${category}`);
        const stores = await response.json();
        
        document.getElementById('storesList').innerHTML = `
            <h3>Поиск будет осуществляться по магазинам:</h3>
            <div>
                ${stores.map(store => `<a href="${store.url}" target="_blank">${store.name}</a>`).join('')}
            </div>
        `;
        document.getElementById('searchSection').style.display = 'block';
        document.getElementById('productsList').innerHTML = '';
    } catch (error) {
        console.error('Ошибка при загрузке магазинов:', error);
    }
}

async function searchProducts() {
    const query = document.getElementById('searchInput').value;
    if (!query || !selectedCategory) return;

    try {
        const response = await fetch(`/api/products?category=${selectedCategory}&query=${encodeURIComponent(query)}`);
        const products = await response.json();
        
        document.getElementById('productsList').innerHTML = products.map(product => `
            <div class="product-card">
                <img src="${product.image}" alt="${product.name}" class="product-image">
                <div class="product-info">
                    <h3>${product.name}</h3>
                    ${product.discountPrice ? `
                        <span class="price">${product.price} ₽</span>
                        <span class="discount-price">${product.discountPrice} ₽</span>
                    ` : `
                        <span>${product.price} ₽</span>
                    `}
                    <p><a href="${product.link}" target="_blank">Перейти к товару</a></p>
                </div>
            </div>
        `).join('');
    } catch (error) {
        console.error('Ошибка при поиске товаров:', error);
    }
}

// Обработка Enter в поле ввода
document.getElementById('searchInput').addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        searchProducts();
    }
});